var commentBox = document.getElementById("commentBox")
		console.log(commentBox)
		
		

commentBox.addEventListener("keypress", submitOnEnter);


		function submitOnEnter(event) {
			if (event.keyCode === 13) {
			let comment = {
				commentDetails: commentBox.value,
				userId: userId,
				postId: postId,
			}
			console.log(comment)
				commentBox.value = ""
				console.log("submitting comment")
				
				fetch(`/createComment`, {
					method: "POST",
					headers: {
						"Content-Type": "application/json",
					},
					body: JSON.stringify(comment)

				}).then(response => response.json);

				return false;
			}
			}
