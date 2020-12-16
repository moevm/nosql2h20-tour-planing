$(document).ready(function () {
    loadPlaces()
})
function loadPlaces() {
    $.ajax({
        type: 'GET',
        url: "/place/all",
        success: function (data) {
            displayAllPlaces(data);
        }
    });
}

let places = [];

function displayAllPlaces(json) {
    var graph = Viva.Graph.graph();
    places = json;
    json.forEach(val => {
        graph.addNode(val.name, {description: val.description, longitude: val.longitude, latitude: val.latitude, imageUrl: val.imageUrl, address: val.address});
    });
    json.forEach(val => {
        val.connectedPlaceIds.forEach(id => {
            let node = json.find(x => x.id === id);
            if (node === null || node === undefined) {
                return;
            }
            graph.addLink(val.name, node.name);
        })
    });

    const nodeSize = 30;
    let graphics = Viva.Graph.View.svgGraphics();
    graphics.node(
        function (node) {
            var ui = Viva.Graph.svg('g'),
                svgText = Viva.Graph.svg('text').attr('y', '-4px').attr('x',
                    '-' + (nodeSize / 8) + 'px').text(node.id),

                img = Viva.Graph.svg(
                    'rect').attr('width', nodeSize)
                    .attr('height', nodeSize).attr('fill', '#00a2e8');

            ui.append(svgText);
            ui.append(img);
            return ui;
        }).placeNode(
        function (nodeUI, pos) {
            nodeUI.attr('transform', 'translate(' + (pos.x - nodeSize / 2)
                + ',' + (pos.y - nodeSize / 2) + ')');
        });

    graphics.link(function (link) {
        return Viva.Graph.svg('path')
            .attr('stroke', 'red')
            .attr('stroke-dasharray', '5, 5');
    }).placeLink(function (linkUI, fromPos, toPos) {
        var data = 'M' + fromPos.x + ',' + fromPos.y +
            'L' + toPos.x + ',' + toPos.y;

        linkUI.attr("d", data);
    });

    var renderer = Viva.Graph.View.renderer(graph, {
        graphics: graphics,
    });

    renderer.run();

    // turn off animation
    renderer.pause();
}

function addPlace() {
    if (places.length === 0) {
        console.log('places are empty')
        alert('places are empty')
        return;
    }
    let connectedPlaces = $("#connectedPlaces").val().split(',');
    var paths = {};

    connectedPlaces.forEach(val => {
        let placeWithDistance = val.split('-')
        let id = places.find(x => x.name = placeWithDistance[0].trim()).id
        paths[id] = {
            distance: placeWithDistance[1]
        };
        }
    )
    let data = {
        address: $("#address").val(),
        description: $("#description").val(),
        imageUrl: $("#imageUrl").val(),
        latitude: $("#latitude").val(),
        longitude: $("#longitude").val(),
        name: $("#placeName").val(),
        paths: paths
    }

    $.ajax({
        type: 'POST',
        url: "/place/save",
        data: JSON.stringify(data),
        datatype: 'json',
        contentType: 'application/json',
        success: function (data) {
            console.log('New place created')
        }
    });
    document.location.reload();
}