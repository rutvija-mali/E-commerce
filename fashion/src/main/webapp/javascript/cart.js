/**
 * 
 */
 
 document.addEventListener('DOMContentLoaded',function(){
	  document.querySelectorAll('select[name="product_qty"]').forEach((select)=>{
		 const product_id = select.id.split("_").pop();
		 const storedQty = localStorage.getItem('selectedQty_'+product_id)
		
		 if(storedQty)
		 {
			 select.value = storedQty;
		 }
	  })
	   calculate();
	   /* fetch("/my-fashion-app/imageServlet",{
	    method:'post',
		  
	  })*/
	 
  })
  let name = "";
  let email = "";
  
 
  
  
 function updateCart(product_id ,qty){
	 localStorage.setItem('selectedQty_'+product_id,qty)
	 calculate();
	  fetch("/my-fashion-app/addToCart/updateQty.jsp",{
		  method:'post',
		  headers:{
			  'Content-Type':'application/x-www-form-urlencoded',
			   
		  },
		  body:`product_id=${product_id}&product_qty=${qty}`
	  })
    
  }

  function calculate(){
	  let sub = 0;
	  let deliveryCharges = 99;
	const priceElements = document.querySelectorAll('.price-new')
	       priceElements.forEach((priceElement)=>{
		  const  product_id = priceElement.id.split("_").pop();
		  const price = Number(priceElement.innerText);
		
		  localStorage.setItem("slectedPrice_"+product_id,price);
		  
		  const storedPrice = localStorage.getItem("slectedPrice_"+product_id);
		  const storedQty = localStorage.getItem('selectedQty_'+product_id)
		  
		  sub += storedPrice * storedQty
		
	  })
	  document.getElementById('subTotal').innerText = sub;
	  if(sub>0){
		  document.getElementById('deliveryCharges').innerText = deliveryCharges //check it later
	  }
	  document.getElementById('total-price').innerText = sub+deliveryCharges
  }
  
  function completeOrder(paymentId,orderId,status){
	console.log("complete order......")
	
  
	fetch("/my-fashion-app/updateOrderServlet",{
	
		method:'post',
		headers:{
			'Content-Type':'application/json'
		},
		body:JSON.stringify({
			paymentId:paymentId,
			orderId:orderId,
			status:status,
			
		})
	}).then((response)=>{
		if(response.ok){
			localStorage.clear();
		}
	}).catch(error=>{
		  console.log("Error recording payment :"+ error)
		  alert("Error in creating order, please try later") // add msg later
	  })
	
	
   }
  
  function createOrder(){
	  totalPrice = document.getElementById('total-price').innerText;
	  console.log(totalPrice);
	  console.log(JSON.stringify({price:totalPrice}))
	  if(totalPrice == ""||totalPrice == null ){
		  alert("Cart is empty")
	  } 
	   fetch("/my-fashion-app/userServlet",{
	    method:'post',
		  
	  })
	  .then((response)=>{
		  return response.json();
	  })
	  .then((user)=>{
		  name = user.name;
		  console.log(name);
		  email = user.email;
		   console.log(email);
	  })
	  
	       
	  fetch("/my-fashion-app/orderServlet",{
		  method:'post',
		  headers:{
			'Content-Type':'application/json' 
		  },
		  body:JSON.stringify({price:totalPrice})
	  }).then(response =>{
		  console.log(response)
		  if(!response.ok){
			  throw new Error('Network response was not ok')
		  }
		   return response.json(); 
		 
	  }).then(data=>{
		  console.log("Order created successfully :" + data)
		   if(data.status == "created" ){
			  // open form
			  var options = {
				  "key":"rzp_test_yVDgRhYuDx3lXm",
				  "amount":data.amount,
				  "currency":"INR",
				  "name":"Fashion",
				  
				  "description":'Payment for Order #123',
				  "image":"http://localhost:8082/my-fashion-app/img/product/img.png",
				  "theme":{
				           color: '#999'  // Custom primary color
				       },
				   "prefill":{
					   "name":name,
					   "email":email,
					   
				   },
				  "order_id":data.id,
				  "handler":function(data){
					  console.log(data.razorpay_payment_id)
					  console.log(data.razorpay_order_id)
					  console.log(data.razorpay_signature)
					  // call function to complete order
					  completeOrder(data.razorpay_payment_id,data.razorpay_order_id,"paid");
				  }
				  
			 
			  }
			   let rzp = new Razorpay(options);
		        rzp.on('payment.failed', function (data){
				console.log(data.error.code);
				console.log(data.error.description);
				console.log(data.error.source);
				console.log(data.error.step);
				console.log(data.error.reason);
				console.log(data.error.metadata.order_id);
				console.log(data.error.metadata.payment_id);
				
				
				});
			rzp.open();
		  
		  }
	  }).catch(error=>{
		  console.log("Error in creating order :"+ error)
		  alert("Error in creating order, please try later")
	  })
  }
  

 
 
  
 