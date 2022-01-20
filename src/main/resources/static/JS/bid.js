var bidText= document.getElementById("bidText")
var anchor = document.getElementById("link")
var url = ""
var message = ""

bidText.addEventListener('change', () =>{
	 message = bidText.value
	 console.log(message)
	url = "mailto:"+ otherEmail +"?subject=Bid from: "+ name +"&body="+ message
    console.log(url)
    anchor.setAttribute("href", url);
})