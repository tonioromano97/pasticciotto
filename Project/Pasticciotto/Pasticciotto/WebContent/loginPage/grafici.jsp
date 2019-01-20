<h1> Grafici</h1>
<div style="width:45%; float:left;">
<canvas id="entrate" style="background-color:white; border-radius:10px;"></canvas>
</div>
<div style="width:45%; display:inline-block; margin-left:5%;">
<canvas id="uscite" style="background-color:white; border-radius:10px;"></canvas>
</div>
<script>
$( document ).ready(function() {
	var configEntrate = {
			type: 'line',
			data: {
				labels: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'],
				datasets: [{
					label: 'Prodotti',
					backgroundColor: window.chartColors.yellow,
					borderColor: window.chartColors.yellow,
					data: [
						90,100,70,30,150,130
					],
					fill: false,
				}, {
					label: 'Bonifici',
					fill: false,
					backgroundColor: window.chartColors.orange,
					borderColor: window.chartColors.orange,
					data: [
						200,100,140,140,150,190
					],
				}]
			},
			options: {
				responsive: true,
				title: {
					display: true,
					text: 'Entrate'
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
	var configUscite = {
			type: 'line',
			data: {
				labels: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'],
				datasets: [{
					label: 'Gas',
					backgroundColor: window.chartColors.green,
					borderColor: window.chartColors.green,
					data: [
						10,20,30,10,20,30
					],
					fill: false,
				},{
					label: 'Luce',
					backgroundColor: window.chartColors.red,
					borderColor: window.chartColors.red,
					data: [
						30,10,20,40,33,25
					],
					fill: false,
				}, {
					label: 'Acqua',
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
				title: {
					display: true,
					text: 'Uscite'
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
	var e = document.getElementById("entrate");
	var u = document.getElementById("uscite");
	var entrate = new Chart(e, configEntrate);
	var uscite = new Chart(u, configUscite);
});
</script>
