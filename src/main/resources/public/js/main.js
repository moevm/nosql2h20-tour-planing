$(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: "/ajax/get",
            data: {id: 0},
            success: function (data) {
                if (data !== null) {
                   let name=$("#name").text()
                    $("#name").html(name + data.name);
                }
            }
        });
});