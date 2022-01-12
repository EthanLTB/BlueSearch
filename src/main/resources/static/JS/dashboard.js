var commentBox = document.getElementById("commentBox")
console.log(commentBox)
var commentBtn = document.getElementById("commentBtn")
console.log(commentBtn)

commentBtn.addEventListener("click", submit);



function submit(event) {
	let comment = {
		commentDetails: commentBox.value,
		userId: [[${user.userId}]],
		postId: [[${post.postId}]],
	}
	
		commentBox.value = ""
		console.log("submitting comment")
		
		fetch(`/createComment`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(comment)

		}).then(response => response.json));

		return false;
	}
