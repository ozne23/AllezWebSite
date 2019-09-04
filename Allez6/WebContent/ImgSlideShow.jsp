
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name = "viewport" content = "width=device-width, 
inital-scale = 1" charset="UTF-8">
<!--  <link rel = "stylesheet" href ="https://www.w3schools.com/w3css/4/w3.css">-->
<link rel = "stylesheet" href ="./css/ImgSlideShow.css">


</head>
<body>

		<div class ="container">
			<img class ="mySlides" alt="IMG 1" src="./Slidepic/Bushido2.jpg">
			<img class ="mySlides" alt="IMG 2" src="./Slidepic/LUT2logo-laterale.jpg">
			<!-- <img class ="mySlides" alt="IMG 3" src="./Slidepic/slidepic3.jpeg">
			<img class ="mySlides" alt="IMG 4" src="">-->
			
			<button class="buttonSlide display-left" onclick="plusDivs(-1)">&#10094;</button>
			<button class="buttonSlide display-right" onclick="plusDivs(+1)">&#10095;</button>
		</div>


<script>
var slideIndex = 1;
var time;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
  clearTimeout(time);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  x[slideIndex-1].style.display = "block";
}

showSlides();

function showSlides() {

	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  for (i = 0; i < slides.length; i++) {
	    slides[i].style.display = "none"; 
	  }
	  slideIndex++;
	  if (slideIndex > slides.length) {slideIndex = 1} 
	  slides[slideIndex-1].style.display = "block";
	  var time = setTimeout(showSlides, 5000); // Change image every 2 seconds
	  
  
}

</script>
</body>
</html>
