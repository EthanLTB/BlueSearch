//var jobTextBox = document.getElementById("createPostBox")
//jobTextBox.addEventListener("keypress", submitOnEnter)
// const token = document.querySelector('meta[name="_csrf"]').content;
// const header = document.querySelector('meta[name="_csrf_parameterName"]').content;
setInterval(getJobs, 3000)

//function submitOnEnter(event) {
//	if (event.keyCode === 13) {
//		let postDescription = jobTextBox.value
//			console.log(postDescription)
//		jobTextBox.value = ""
//		console.log("creating post")
//		
//		fetch("/dashboard/createPost", {
//			method: "POST",
//			headers: {
//				"Content-Type": "application/json",
//				 header: token,
//			},
//			body: JSON.stringify(postDescription)
//
//		}).then(response => response.json)
//
//		return false;
//	}
//}


function getJobs(){
	console.log("Getting all posts")
	fetch("/getPosts", {
		method: "POST",
		headers: {
				"Content-Type": "application/json"
		}
		}).then(response => response.json()).then(data => appendMessages(data))
//		.then(function (data){ 
//			appendMessages(data)
//		
//	})
	
	
}

function appendMessages(data) {
	console.log("Showing posts")
	 var jobBoard = document.getElementById("jobBoard")
	jobBoard.innerHTML = "";
	for (var i = 0; i < data.length; i++) {
		var div = document.createElement("div");
		div.innerHTML = `<div>
			  <span>${data[i].userId}</span>
		  	  <span class="message">${data[i].jobDescription}</span>
			  <span class="timestamp">${data[i].createdDate}: </span>
			</div>
			<hr>`
		jobBoard.appendChild(div);
	}
	
			
	}