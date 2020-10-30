
function deleteDevice(deviceId){
	console.log("deleting device");
	var form = document.getElementById("form"+deviceId);
	form.submit();
}

function select(element){
    element.classList.add("selected");
}
function unselect(element){
    element.classList.remove("selected");
}

function hide(id){
    var element = document.getElementById(id);
    element.classList.add("hide");
}
function show(id){
    var element = document.getElementById(id);
    element.classList.remove("hide");
}

function selectHome(id){
	  var homesList = document.getElementById("homesList");
	    var homes = homesList.getElementsByTagName("li");
	    for(let i = 0; i < homes.length; i++){
	    	unselect(homes[i]);
	    }
	    document.getElementById("home"+id).classList.add("selected");
	    document.getElementById("form"+id).submit();

}

function setSelectedHome(id){
    console.log("setting home: "+id);
    document.getElementById("home"+id).classList.add("selected");
}

function checkIfHome(home){
    if(home.id == id) home.classList.add("selected");
}
/*
Modal stuff
*/


// Get the modal
var modal = document.getElementById("modal");
var addHomeModalContent= document.getElementById("addHomeModalContent");
var removeHomeModalContent= document.getElementById("removeHomeModalContent");
var infoModalContent= document.getElementById("infoModalContent");
if(infoModalContent == null) console.log("that stuff is null yo!");
if(infoModalContent != null) console.log("that stuff is not null yo!");
// Get the button that opens the modal
var addHomeBtn = document.getElementById("addHomeBtn");
var removeHomeBtn = document.getElementById("removeHomeBtn");
var changeInfoBtn = document.getElementById("changeInfoBtn");
// Get the <span> element that closes the modal
var closeBtn = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
addHomeBtn.onclick = function() {
    console.log("OPEN SESAME");
    modal.style.display = "block";
    addHomeModalContent.style.display = "block";
    removeHomeModalContent.style.display = "none";
    infoModalContent.style.display = "none";
    
}
removeHomeBtn.onclick = function() {
    console.log("OPEN SESAME");
    modal.style.display = "block";
    removeHomeModalContent.style.display = "block";
    infoModalContent.style.display = "none";
    addHomeModalContent.style.display = "none";

}
changeInfoBtn.onclick = function() {
    console.log("OPEN SESAME");
    modal.style.display = "block";
    infoModalContent.style.display = "block";
    addHomeModalContent.style.display = "none";
    removeHomeModalContent.style.display = "none";
}
// When the user clicks on <span> (x), close the modal
closeBtn.onclick = function() {
  modal.style.display = "none";
}
function closeModal(){
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}