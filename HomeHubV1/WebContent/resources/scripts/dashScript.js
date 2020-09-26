var roomsList = [];
var roomTabs;
var devicesList = [];
var deviceGrid;
var deviceId = 0;
//panel
var profile = document.getElementById("profile");
var panel = document.getElementById("panelContent");
//Color Changing variables
var redValue = document.getElementById("redSlider").value;
var redText = document.getElementById("redText");
var greenValue;
var greenText = document.getElementById("greenText");
var blueValue;
var blueText = document.getElementById("blueText");

//Saved Colors varaiables
var savedColorsGrid = document.getElementById("savedColors");
var savedColorsList;

initColor();

function changeActive(deviceId){
    var active = document.getElementById("aciveSettingsCheckBox");
    // SEND THE CHANGE STATE TO THE DATABASE WITH A FETCH
}
function changeBrightness(deviceId){
    var brightness = document.getElementById("brightnessSettingsSlider");
    // SEND THE CHANGE STATE TO THE DATABASE WITH A FETCH
}

function updateSlider(color){
    var colorCricle = document.getElementById("colorCircle");
    switch(color){
        case "red":
            redValue = document.getElementById("redSlider").value;
            redText.innerHTML = "red: "+redValue;
            break;
        case "green":
            greenValue = document.getElementById("greenSlider").value;
            greenText.innerHTML = "green: "+greenValue;
            break;
        case "blue":
            blueValue = document.getElementById("blueSlider").value;
            blueText.innerHTML = "blue: "+blueValue;
            break;
        default:
            break;
        
    }
    colorCricle.style.backgroundColor = "rgb("+redValue+","+greenValue+","+blueValue+")";
}
function openRoom(roomId){
    var deviceList = document.getElementsByClassName("card");
    for(let i = 0; i < deviceList.length;i++){
        if(deviceList[i].classList.contains("room"+roomId)){
            deviceList[i].classList.remove("hide");
        }
        else{
            deviceList[i].classList.add("hide");
        }
    }
    
}
function initColor(){
    var colorCricle = document.getElementById("colorCircle");
        redValue = document.getElementById("redSlider").value;
        redText.innerHTML = "red: "+redValue;

        greenValue = document.getElementById("greenSlider").value;
        greenText.innerHTML = "green: "+greenValue;

        blueValue = document.getElementById("blueSlider").value;
        blueText.innerHTML = "blue: "+blueValue;

    colorCricle.style.backgroundColor = "rgb("+redValue+","+greenValue+","+blueValue+")";
}
function loadSavedColors(colors){

    for(i=0; i < colors.length; i++){
        var color = colors[i];
        var div = document.createElement("DIV"); // create div element
        div.classList.add("colorCircle"); // add the "colorCircle" class to the div
        div.style.backgroundColor = "rgb("+color.red+", "+color.green+", "+color.blue+") "; // change the background color to the correct color
        savedColorsGrid.appendChild(div); // add the div to the containerGrid
    }
}
function saveColor(){
    var div = document.createElement("DIV"); // create div element
    div.onclick = selectColor(div);
    div.classList.add("colorCircle"); // add the "colorCircle" class to the div
    div.style.backgroundColor = "rgb("+redValue+", "+greenValue+", "+blueValue+") "; // change the background color to the correct color
    savedColorsGrid.appendChild(div); // add the div to the containerGrid
    //add the color to the device in the backend
}

function selectColor(colorObject){
    var children = document.querySelectorAll('.colorCircle.selected');
    children.forEach(child =>{
        if(child.classList.contains("selected")) child.classList.remove("selected");
    });
    colorObject.classList.add("selected"); //add class "selected" to new div
    // SEND THE CHANGE STATE TO THE DATABASE WITH A FETCH
    return colorObject;
}

function togglePanel(deviceId){

    var profile = document.getElementById("profileHeader");
    var panel = document.getElementById("panelContent");
    var panelCol = document.getElementById("panelCol");
    profile.classList.toggle("toggled");
    panel.classList.toggle("toggled");
    panelCol.classList.toggle("toggled");
    if(deviceId != null) this.deviceId = deviceId;
}

function switchToPanelTab(tab){
    var divSettings = document.getElementById("settings");
    var divLight = document.getElementById("lightSettings");
    var divDefault = document.getElementById("defaultSettings");
    var divDash = document.getElementById("dash");
    switch(tab){
        case "settings":
            divSettings.classList.remove("hide");
            divLight.classList.add("hide")
            divDash.classList.add("hide")
            divDefault.classList.add("hide");
            break;
        case "dash":
            divDash.classList.remove("hide");
            divLight.classList.add("hide")
            divSettings.classList.add("hide")
            divDefault.classList.add("hide");
            break;
        case "device":
            divDefault.classList.remove("hide");
            divLight.classList.add("hide");
            divSettings.classList.add("hide")
            divDash.classList.add("hide")
            break;
        case "light":
            divLight.classList.remove("hide");
            divDefault.classList.add("hide");
            divSettings.classList.add("hide")
            divDash.classList.add("hide")
            break;
        default:
            break;
        
    }
}


function addDevice(){
    //validate the info in the form
    //send it to the database with a fetch
    //reload page?
}

function addRoom(){
    //validate the info in the form
    //send it to the database with a fetch
    //reload page?
}
function openDeviceSettings(deviceId){
    togglePanel(deviceId);
    switchToPanelTab("device");
}
function openDeviceSettings(deviceId, type){
	console.log("open device 2");
    togglePanel(deviceId);
    if(type == "light"){
    	console.log("light");
    	switchToPanelTab("light");
    }
    else{
    	console.log("defualt");
    	switchToPanelTab("device");
    }
    
}

/*
Modal stuff
*/


// Get the modal
var modal = document.getElementById("modal");
var deviceModalContent= document.getElementById("deviceModalContent");
var roomModalContent= document.getElementById("roomModalContent");

// Get the button that opens the modal
var addDeviceBtn = document.getElementById("addDeviceBtn");
var addRoomBtn = document.getElementById("addRoomBtn");
// Get the <span> element that closes the modal
var closeBtn = document.getElementsByClassName("close");

// When the user clicks on the button, open the modal
addDeviceBtn.onclick = function() {
  modal.style.display = "block";
  deviceModalContent.style.display = "block";
  roomModalContent.style.display = "none";
}
addRoomBtn.onclick = function() {
    modal.style.display = "block";
    roomModalContent.style.display = "block";
    deviceModalContent.style.display = "none";
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