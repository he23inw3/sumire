$(document).ready(function() {
	$(".btn").on("click", function() {
		var value = $(this).attr("value");
		if (value) {
			showDialog(".successDialog");
		} else {
			showDialog(".failedDialog");
		}
	});

	 function showDialog(className) {
		$(className).dialog({
			title: "回答",
			autoClose: false,
			modal: false,
			position: {
				my: "center top",
				at: "center top+150"
			},
			buttons: {
				"OK": function() {
					$(this).dialog("close");
					history.back();
				}
			}
		});
	}
});