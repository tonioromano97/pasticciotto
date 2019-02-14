<%@ page import="bean.Finanza,bean.Entrata,bean.Uscita,java.util.ArrayList" %>
<%
	String datiEntrate = (String) request.getSession().getAttribute("entry");
	//String datiBolletta = (String) request.getSession().getAttribute("outBolletta");
	//String datiFornitura = (String) request.getSession().getAttribute("outFornitura");
	//String datiAltro = (String) request.getSession().getAttribute("outAltro");
%>
<div style="width:45%; float:left;">
<canvas id="entrate" style="background-color:transparent; border-radius:10px;"></canvas>
</div>
<div style="width:45%; display:inline-block; margin-left:5%;">
<canvas id="uscite" style="background-color:transparent; border-radius:10px;"></canvas>
</div>
<script>
$( document ).ready(function() {
	var configEntrate = {
			type: 'line',
			data: {
				labels: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'],
				datasets: [{
					label: 'Prodotti',
					labelsColor: 'white',
					backgroundColor: window.chartColors.yellow,
					borderColor: window.chartColors.yellow,
					data: [<%=datiEntrate %>],
					fill: false,
				}]
			},
			options: {
				responsive: true,
				legend: {
					labels : {
						fontColor:"white"
					}
				},
				title: {
					display: true,
					text: 'Entrate',
					fontColor:"white"
				},
				tooltips: {
					mode: 'index',
					intersect: false,
				},
				hover: {
					mode: 'nearest',
					intersect: true
				},
				scales: {
					xAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Mesi',
							fontColor:"white"
						},
						ticks :{
							fontColor: "white"
						}
					}],
					yAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Euro',
							fontColor:"white"
						},
						ticks :{
							fontColor: "white"
						}
					}]
				}
			}
		};
	var configUscite = {
			type: 'line',
			data: {
				labels: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'],
				datasets: [{
					label: 'Bolletta',
					backgroundColor: window.chartColors.green,
					borderColor: window.chartColors.green,
					data: [
						10,20,30,10,20,30
					],
					fill: false,
				},{
					label: 'Fornitura',
					backgroundColor: window.chartColors.red,
					borderColor: window.chartColors.red,
					data: [
						30,10,20,40,33,25
					],
					fill: false,
				}, {
					label: 'Altro',
					fill: false,
					backgroundColor: window.chartColors.blue,
					borderColor: window.chartColors.blue,
					data: [
						20,25,22,30,35,40
					],
				}]
			},
			options: {
				responsive: true,
				legend: {
					labels : {
						fontColor:"white"
					}
				},
				title: {
					display: true,
					text: 'Uscite',
					fontColor:"white"
				},
				tooltips: {
					mode: 'index',
					intersect: false,
				},
				hover: {
					mode: 'nearest',
					intersect: true
				},
				scales: {
					xAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Mesi',
							fontColor:"white"
						},
						ticks :{
							fontColor: "white"
						}
					}],
					yAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Euro',
							fontColor:"white"
						},
						ticks :{
							fontColor: "white"
						}
					}]
				}
			}
		};
	var e = document.getElementById("entrate");
	var u = document.getElementById("uscite");
	var entrate = new Chart(e, configEntrate);
	var uscite = new Chart(u, configUscite);
});
</script>
