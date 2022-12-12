<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Perform.Chess,Perform.Color,Perform.Pawn,Perform.Piece,Perform.GridMaps,Perform.Player,Perform.King,
				Save.SaveBoard, Save.RetrieveBoard" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
    td {
        width: 50px;
        height: 50px;
        text-align: center;
    }
</style>
<title>A Simple Chess API</title>
</head>
<script type="text/javascript">
	var count = 0;
	function pieceSelected(name) {
		if(count == 0){
			document.getElementById("sq1").value = name;
		} else if (count == 1) {
			document.getElementById("sq2").value = name;
		} else {
			document.getElementById("sq1").value = "";
			document.getElementById("sq2").value = "";
			console.log("Too many clicks.. Start over!");
		}
		count++;
		console.log(count);
    }
</script>
<body bgcolor="cyan">
<form method="post" action="EOCheck">
		<input id="sq1" type="text" name="sq1">
		<input id="sq2" type="text" name="sq2">
		<input type="submit" value="Update Board">
	<%
		String sq1 = "P1W";
		String sq2 = "E";
		String checkStatus = "";
		Player p1 = (Player)request.getSession().getAttribute("player1");
		if(p1 != null)
			checkStatus = p1.king.kingInCheck() == true ? "Check" : "Not in Check";
		if(request.getAttribute("mySquare") != null){
			sq2 = request.getAttribute("mySquare").toString();
		}
		if(request.getAttribute("myInitial") != null){
			sq1 = request.getAttribute("myInitial").toString();
		}
		
		boolean myBool = GridMaps.chessboard.containsKey("C1");
		
		String pieceAtA1 = GridMaps.chessboard.containsKey("A1") ? 
   				"<img src='" + GridMaps.chessboard.get("A1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB1 = GridMaps.chessboard.containsKey("B1") ? 
				"<img src='" + GridMaps.chessboard.get("B1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC1 = GridMaps.chessboard.containsKey("C1") ? 
	    		"<img src='" + GridMaps.chessboard.get("C1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD1 = GridMaps.chessboard.containsKey("D1") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE1 = GridMaps.chessboard.containsKey("E1") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF1 = GridMaps.chessboard.containsKey("F1") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG1 = GridMaps.chessboard.containsKey("G1") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH1 = GridMaps.chessboard.containsKey("H1") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H1").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    
	    String pieceAtA2 = GridMaps.chessboard.containsKey("A2") ? 
   				"<img src='" + GridMaps.chessboard.get("A2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB2 = GridMaps.chessboard.containsKey("B2") ? 
				"<img src='" + GridMaps.chessboard.get("B2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC2 = GridMaps.chessboard.containsKey("C2") ? 
	    		"<img src='" + GridMaps.chessboard.get("C2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD2 = GridMaps.chessboard.containsKey("D2") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE2 = GridMaps.chessboard.containsKey("E2") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF2 = GridMaps.chessboard.containsKey("F2") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG2 = GridMaps.chessboard.containsKey("G2") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH2 = GridMaps.chessboard.containsKey("H2") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H2").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    
	    String pieceAtA3 = GridMaps.chessboard.containsKey("A3") ? 
   				"<img src='" + GridMaps.chessboard.get("A3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB3 = GridMaps.chessboard.containsKey("B3") ? 
				"<img src='" + GridMaps.chessboard.get("B3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC3 = GridMaps.chessboard.containsKey("C3") ? 
	    		"<img src='" + GridMaps.chessboard.get("C3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD3 = GridMaps.chessboard.containsKey("D3") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE3 = GridMaps.chessboard.containsKey("E3") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF3 = GridMaps.chessboard.containsKey("F3") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG3 = GridMaps.chessboard.containsKey("G3") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH3 = GridMaps.chessboard.containsKey("H3") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H3").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    
	    String pieceAtA4 = GridMaps.chessboard.containsKey("A4") ? 
   				"<img src='" + GridMaps.chessboard.get("A4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB4 = GridMaps.chessboard.containsKey("B4") ? 
				"<img src='" + GridMaps.chessboard.get("B4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC4 = GridMaps.chessboard.containsKey("C4") ? 
	    		"<img src='" + GridMaps.chessboard.get("C4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD4 = GridMaps.chessboard.containsKey("D4") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE4 = GridMaps.chessboard.containsKey("E4") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF4 = GridMaps.chessboard.containsKey("F4") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG4 = GridMaps.chessboard.containsKey("G4") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH4 = GridMaps.chessboard.containsKey("H4") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H4").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    
	    String pieceAtA5 = GridMaps.chessboard.containsKey("A5") ? 
   				"<img src='" + GridMaps.chessboard.get("A5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB5 = GridMaps.chessboard.containsKey("B5") ? 
				"<img src='" + GridMaps.chessboard.get("B5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC5 = GridMaps.chessboard.containsKey("C5") ? 
	    		"<img src='" + GridMaps.chessboard.get("C5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD5 = GridMaps.chessboard.containsKey("D5") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE5 = GridMaps.chessboard.containsKey("E5") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF5 = GridMaps.chessboard.containsKey("F5") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG5 = GridMaps.chessboard.containsKey("G5") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH5 = GridMaps.chessboard.containsKey("H5") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H5").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    
	    String pieceAtA6 = GridMaps.chessboard.containsKey("A6") ? 
   				"<img src='" + GridMaps.chessboard.get("A6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB6 = GridMaps.chessboard.containsKey("B6") ? 
				"<img src='" + GridMaps.chessboard.get("B6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC6 = GridMaps.chessboard.containsKey("C6") ? 
	    		"<img src='" + GridMaps.chessboard.get("C6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD6 = GridMaps.chessboard.containsKey("D6") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE6 = GridMaps.chessboard.containsKey("E6") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF6 = GridMaps.chessboard.containsKey("F6") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG6 = GridMaps.chessboard.containsKey("G6") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH6 = GridMaps.chessboard.containsKey("H6") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H6").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    
	    String pieceAtA7 = GridMaps.chessboard.containsKey("A7") ? 
   				"<img src='" + GridMaps.chessboard.get("A7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB7 = GridMaps.chessboard.containsKey("B7") ? 
				"<img src='" + GridMaps.chessboard.get("B7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC7 = GridMaps.chessboard.containsKey("C7") ? 
	    		"<img src='" + GridMaps.chessboard.get("C7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD7 = GridMaps.chessboard.containsKey("D7") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE7 = GridMaps.chessboard.containsKey("E7") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF7 = GridMaps.chessboard.containsKey("F7") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG7 = GridMaps.chessboard.containsKey("G7") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH7 = GridMaps.chessboard.containsKey("H7") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H7").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    
	    String pieceAtA8 = GridMaps.chessboard.containsKey("A8") ? 
   				"<img src='" + GridMaps.chessboard.get("A8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
		String pieceAtB8 = GridMaps.chessboard.containsKey("B8") ? 
				"<img src='" + GridMaps.chessboard.get("B8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtC8 = GridMaps.chessboard.containsKey("C8") ? 
	    		"<img src='" + GridMaps.chessboard.get("C8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtD8 = GridMaps.chessboard.containsKey("D8") ? 
   	    	    "<img src='" + GridMaps.chessboard.get("D8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	   	String pieceAtE8 = GridMaps.chessboard.containsKey("E8") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("E8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtF8 = GridMaps.chessboard.containsKey("F8") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("F8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtG8 = GridMaps.chessboard.containsKey("G8") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("G8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
	    String pieceAtH8 = GridMaps.chessboard.containsKey("H8") ? 
	   	    	"<img src='" + GridMaps.chessboard.get("H8").getImageName() + ".jpg' width='100%' height='100%' alt='girl'>" : "E";
  	    	    	    
		int code = response.getStatus();
		
	%>

</form>
<br><br>

<p id="checkingcheck"><%= checkStatus %></p>

<h1>A game of chess?</h1>
	<div class="chessboard">
        <table>
            <tr>
                <td id="A1" onclick="pieceSelected('A1')"><a href="#"></a></td>
                <td id="A2" onclick="pieceSelected('A2')"><a href="#"></a></td>
                <td id="A3" onclick="pieceSelected('A3')"><a href="#"></a></td>
                <td id="A4" onclick="pieceSelected('A4')"><a href="#"></a></td>
                <td id="A5" onclick="pieceSelected('A5')"><a href="#"></a></td>
                <td id="A6" onclick="pieceSelected('A6')"><a href="#"></a></td>
                <td id="A7" onclick="pieceSelected('A7')"><a href="#"></a></td>
                <td id="A8" onclick="pieceSelected('A8')"><a href="#"></a></td>
            </tr>
            <tr>
                <td id="B1" onclick="pieceSelected('B1')"><a href="#"></a></td>
                <td id="B2" onclick="pieceSelected('B2')"><a href="#"></a></td>
                <td id="B3" onclick="pieceSelected('B3')"><a href="#"></a></td>
                <td id="B4" onclick="pieceSelected('B4')"><a href="#"></a></td>
                <td id="B5" onclick="pieceSelected('B5')"><a href="#"></a></td>
                <td id="B6" onclick="pieceSelected('B6')"><a href="#"></a></td>
                <td id="B7" onclick="pieceSelected('B7')"><a href="#"></a></td>
                <td id="B8" onclick="pieceSelected('B8')"><a href="#"></a></td>
            </tr>
            <tr>
                <td id="C1" onclick="pieceSelected('C1')"><a href="#"></a></td>
                <td id="C2" onclick="pieceSelected('C2')"><a href="#"></a></td>
                <td id="C3" onclick="pieceSelected('C3')"><a href="#"></a></td>
                <td id="C4" onclick="pieceSelected('C4')"><a href="#"></a></td>
                <td id="C5" onclick="pieceSelected('C5')"><a href="#"></a></td>
                <td id="C6" onclick="pieceSelected('C6')"><a href="#"></a></td>
                <td id="C7" onclick="pieceSelected('C7')"><a href="#"></a></td>
                <td id="C8" onclick="pieceSelected('C8')"><a href="#"></a></td>
            </tr>
            <tr>
                <td id="D1" onclick="pieceSelected('D1')"><a href="#"></a></td>
                <td id="D2" onclick="pieceSelected('D2')"><a href="#"></a></td>
                <td id="D3" onclick="pieceSelected('D3')"><a href="#"></a></td>
                <td id="D4" onclick="pieceSelected('D4')"><a href="#"></a></td>
                <td id="D5" onclick="pieceSelected('D5')"><a href="#"></a></td>
                <td id="D6" onclick="pieceSelected('D6')"><a href="#"></a></td>
                <td id="D7" onclick="pieceSelected('D7')"><a href="#"></a></td>
                <td id="D8" onclick="pieceSelected('D8')"><a href="#"></a></td>
            </tr>
            <tr>
                <td id="E1" onclick="pieceSelected('E1')"><a href="#"></a></td>
                <td id="E2" onclick="pieceSelected('E2')"><a href="#"></a></td>
                <td id="E3" onclick="pieceSelected('E3')"><a href="#"></a></td>
                <td id="E4" onclick="pieceSelected('E4')"><a href="#"></a></td>
                <td id="E5" onclick="pieceSelected('E5')"><a href="#"></a></td>
                <td id="E6" onclick="pieceSelected('E6')"><a href="#"></a></td>
                <td id="E7" onclick="pieceSelected('E7')"><a href="#"></a></td>
                <td id="E8" onclick="pieceSelected('E8')"><a href="#"></a></td>
            </tr>
            <tr>
                <td id="F1" onclick="pieceSelected('F1')"><a href="#"></a></td>
                <td id="F2" onclick="pieceSelected('F2')"><a href="#"></a></td>
                <td id="F3" onclick="pieceSelected('F3')"><a href="#"></a></td>
                <td id="F4" onclick="pieceSelected('F4')"><a href="#"></a></td>
                <td id="F5" onclick="pieceSelected('F5')"><a href="#"></a></td>
                <td id="F6" onclick="pieceSelected('F6')"><a href="#"></a></td>
                <td id="F7" onclick="pieceSelected('F7')"><a href="#"></a></td>
                <td id="F8" onclick="pieceSelected('F8')"><a href="#"></a></td>
            </tr>
            <tr>
                <td id="G1" onclick="pieceSelected('G1')"><a href="#"></a></td>
                <td id="G2" onclick="pieceSelected('G2')"><a href="#"></a></td>
                <td id="G3" onclick="pieceSelected('G3')"><a href="#"></a></td>
                <td id="G4" onclick="pieceSelected('G4')"><a href="#"></a></td>
                <td id="G5" onclick="pieceSelected('G5')"><a href="#"></a></td>
                <td id="G6" onclick="pieceSelected('G6')"><a href="#"></a></td>
                <td id="G7" onclick="pieceSelected('G7')"><a href="#"></a></td>
                <td id="G8" onclick="pieceSelected('G8')"><a href="#"></a></td>
            </tr>
            <tr>
                <td id="H1" onclick="pieceSelected('H1')"><a href="#"></a></td>
                <td id="H2" onclick="pieceSelected('H2')"><a href="#"></a></td>
                <td id="H3" onclick="pieceSelected('H3')"><a href="#"></a></td>
                <td id="H4" onclick="pieceSelected('H4')"><a href="#"></a></td>
                <td id="H5" onclick="pieceSelected('H5')"><a href="#"></a></td>
                <td id="H6" onclick="pieceSelected('H6')"><a href="#"></a></td>
                <td id="H7" onclick="pieceSelected('H7')"><a href="#"></a></td>
                <td id="H8" onclick="pieceSelected('H8')"><a href="#"></a></td>
            </tr>
        </table>
    </div>
    <div>
    <script>
    document.getElementById("A1").innerHTML = "<%= pieceAtA1 %>";
    document.getElementById("A2").innerHTML = "<%= pieceAtA2 %>";
    document.getElementById("A3").innerHTML = "<%= pieceAtA3 %>";
    document.getElementById("A4").innerHTML = "<%= pieceAtA4 %>";
    document.getElementById("A5").innerHTML = "<%= pieceAtA5 %>";
    document.getElementById("A6").innerHTML = "<%= pieceAtA6 %>";
    document.getElementById("A7").innerHTML = "<%= pieceAtA7 %>";
    document.getElementById("A8").innerHTML = "<%= pieceAtA8 %>";
    
    document.getElementById("B1").innerHTML = "<%= pieceAtB1 %>";
    document.getElementById("B2").innerHTML = "<%= pieceAtB2 %>";
    document.getElementById("B3").innerHTML = "<%= pieceAtB3 %>";
    document.getElementById("B4").innerHTML = "<%= pieceAtB4 %>";
    document.getElementById("B5").innerHTML = "<%= pieceAtB5 %>";
    document.getElementById("B6").innerHTML = "<%= pieceAtB6 %>";
    document.getElementById("B7").innerHTML = "<%= pieceAtB7 %>";
    document.getElementById("B8").innerHTML = "<%= pieceAtB8 %>";
    
    document.getElementById("C1").innerHTML = "<%= pieceAtC1 %>";
    document.getElementById("C2").innerHTML = "<%= pieceAtC2 %>";
    document.getElementById("C3").innerHTML = "<%= pieceAtC3 %>";
    document.getElementById("C4").innerHTML = "<%= pieceAtC4 %>";
    document.getElementById("C5").innerHTML = "<%= pieceAtC5 %>";
    document.getElementById("C6").innerHTML = "<%= pieceAtC6 %>";
    document.getElementById("C7").innerHTML = "<%= pieceAtC7 %>";
    document.getElementById("C8").innerHTML = "<%= pieceAtC8 %>";
    
    document.getElementById("D1").innerHTML = "<%= pieceAtD1 %>";
    document.getElementById("D2").innerHTML = "<%= pieceAtD2 %>";
    document.getElementById("D3").innerHTML = "<%= pieceAtD3 %>";
    document.getElementById("D4").innerHTML = "<%= pieceAtD4 %>";
    document.getElementById("D5").innerHTML = "<%= pieceAtD5 %>";
    document.getElementById("D6").innerHTML = "<%= pieceAtD6 %>";
    document.getElementById("D7").innerHTML = "<%= pieceAtD7 %>";
    document.getElementById("D8").innerHTML = "<%= pieceAtD8 %>";
    
    document.getElementById("E1").innerHTML = "<%= pieceAtE1 %>";
    document.getElementById("E2").innerHTML = "<%= pieceAtE2 %>";
    document.getElementById("E3").innerHTML = "<%= pieceAtE3 %>";
    document.getElementById("E4").innerHTML = "<%= pieceAtE4 %>";
    document.getElementById("E5").innerHTML = "<%= pieceAtE5 %>";
    document.getElementById("E6").innerHTML = "<%= pieceAtE6 %>";
    document.getElementById("E7").innerHTML = "<%= pieceAtE7 %>";
    document.getElementById("E8").innerHTML = "<%= pieceAtE8 %>";
    
    document.getElementById("F1").innerHTML = "<%= pieceAtF1 %>";
    document.getElementById("F2").innerHTML = "<%= pieceAtF2 %>";
    document.getElementById("F3").innerHTML = "<%= pieceAtF3 %>";
    document.getElementById("F4").innerHTML = "<%= pieceAtF4 %>";
    document.getElementById("F5").innerHTML = "<%= pieceAtF5 %>";
    document.getElementById("F6").innerHTML = "<%= pieceAtF6 %>";
    document.getElementById("F7").innerHTML = "<%= pieceAtF7 %>";
    document.getElementById("F8").innerHTML = "<%= pieceAtF8 %>";
    
    document.getElementById("G1").innerHTML = "<%= pieceAtG1 %>";
    document.getElementById("G2").innerHTML = "<%= pieceAtG2 %>";
    document.getElementById("G3").innerHTML = "<%= pieceAtG3 %>";
    document.getElementById("G4").innerHTML = "<%= pieceAtG4 %>";
    document.getElementById("G5").innerHTML = "<%= pieceAtG5 %>";
    document.getElementById("G6").innerHTML = "<%= pieceAtG6 %>";
    document.getElementById("G7").innerHTML = "<%= pieceAtG7 %>";
    document.getElementById("G8").innerHTML = "<%= pieceAtG8 %>";
    
    document.getElementById("H1").innerHTML = "<%= pieceAtH1 %>";
    document.getElementById("H2").innerHTML = "<%= pieceAtH2 %>";
    document.getElementById("H3").innerHTML = "<%= pieceAtH3 %>";
    document.getElementById("H4").innerHTML = "<%= pieceAtH4 %>";
    document.getElementById("H5").innerHTML = "<%= pieceAtH5 %>";
    document.getElementById("H6").innerHTML = "<%= pieceAtH6 %>";
    document.getElementById("H7").innerHTML = "<%= pieceAtH7 %>";
    document.getElementById("H8").innerHTML = "<%= pieceAtH8 %>";
      
</script>
    
    </div>
<form method="post" action="SaveBoard">
	<input type="submit" value="Save Game">
</form>
<div>
	<form method="post" action="RetrieveBoard">
		<input type="submit" value="Retrieve Last Game">
	</form>
</div>
<br><br>
<div>
	<p>
		Black Knight <a href="https://www.rawpixel.com/image/393792">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		White Knight <a href="https://www.rawpixel.com/image/393700">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		White Bishop <a href="https://www.rawpixel.com/image/393739">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		Black Pawn <a href="https://www.rawpixel.com/image/6104241">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		White Pawn <a href="https://www.rawpixel.com/image/393769">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		Black Rook <a href="https://www.rawpixel.com/image/393793">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		White Rook <a href="https://www.rawpixel.com/image/393753">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		Black Queen <a href="https://www.rawpixel.com/image/393786">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		White Queen <a href="https://www.rawpixel.com/image/393771">Image</a> by <a href="https://www.rawpixel.com/">rawpixel.com</a><br>
		Black Bishop <a href="https://www.vectorstock.com/royalty-free-vector/paper-clipped-sticker-chess-piece-bishop-vector-32165953">Vector image by VectorStock / Robot</a><br>
		White King <a href="https://www.vectorstock.com/royalty-free-vector/white-chess-king-piece-on-background-vector-35153439">Vector image by VectorStock / Robot</a><br>
		Black King <a href="https://www.vectorstock.com/royalty-free-vector/black-chess-king-piece-on-white-background-vector-35207410">Vector image by VectorStock / Robot</a>
	</p>
</div>
</body>
</html>