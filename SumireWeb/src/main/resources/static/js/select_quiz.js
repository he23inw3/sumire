$(document).ready(function() {
	$("#myTable").DataTable({
		padding: true,
		pageLength: 5,
		lengthChange: true,
		searching: true,
		autoWidth: false,
		info: true,
		order: [[ 0, 'asc' ]],
		language: {
			decimal: ".",
			emptyTable: "表示するデータがありません。",
			info: "_START_ ～ _END_ / _TOTAL_ 件中",
			infoEmpty: "0 ～ 0 / 0 件",
			infoFiltered: "(合計 _MAX_ 件からフィルタリングしています)",
			zeroRecords:  "一致するデータが見つかりません。",
			lengthMenu: "1ページ _MENU_ 件を表示する",
			loadingRecords: "読み込み中...",
			processing: "処理中...",
			search: "絞り込み:",
			paginate: {
				first: "最初",
				last: "最後",
				next: "次",
				previous: "前"
			},
		},
		buttons: [
			"searchPanes"
		],
		dom: "Bfrtip"
	});
});