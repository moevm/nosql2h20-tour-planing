$(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: "/ajax/neoj4/get",
            data: {id: 0},
            success: function (data) {
                if (data !== null) {
                   let name=$("#neo4j").text()
                    $("#neo4j").html(name + data.name);
                }
            }
        });
});
$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "/ajax/mongo/get",
        data: {id: 0},
        success: function (data) {
            if (data !== null) {
                let name=$("#mongo").text()
                $("#mongo").html(name + data.name);
            }
        }
    });
});