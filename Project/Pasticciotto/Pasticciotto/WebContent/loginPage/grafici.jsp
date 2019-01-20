<h1> Grafici </h1>
<div style="width:45%; float:left;">
<canvas id="canvas1" style="background-color:white; border-radius:10px;"></canvas>
</div>
<div style="width:45%; display:inline-block; margin-left:5%;">
<canvas id="canvas2" style="background-color:white; border-radius:10px;"></canvas>
</div>
<script>
$( document ).ready(function() {
	var config = {
			type: 'line',
			data: {
				labels: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'],
				datasets: [{
					label: 'Entrate',
					backgroundColor: window.chartColors.red,
					borderColor: window.chartColors.red,
					data: [
						10,20,30,10,20,30
					],
					fill: false,
				}, {
					label: 'Uscite',
					fill: false,
					backgroundColor: window.chartColors.blue,
					borderColor: window.chartColors.blue,
					data: [
						30,20,10,30,20,10
					],
				}]
			},
			options: {
				responsive: true,
				title: {
					display: true,
					text: 'Dolce Tentazioni'
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
							labelString: 'Mesi'
						}
					}],
					yAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Euro'
						}
					}]
				}
			}
		};
	var ctx1 = document.getElementById("canvas1");
	var ctx2 = document.getElementById("canvas2");
	var myLineChart1 = new Chart(ctx1, config);
	var myLineChart2 = new Chart(ctx2, config);
});
</script>
