var svg = d3.select("svg"),
    width = +svg.attr("width"),
    height = +svg.attr("height");

var color = d3.scaleOrdinal(d3.schemeCategory20);

var simulation = d3.forceSimulation()
    .force("link", d3.forceLink().distance(10).strength(0.5))
    .force("charge", d3.forceManyBody())
    .force("center", d3.forceCenter(width / 2, height / 2));

// d3.json("graph1.json", function(error, graph) {
// d3.json('/request', {
//     method:"POST",
//     body: JSON.stringify({
//         name: 'Hello',
//         attributeName: '1111'
//     }),
//     headers: {
//         "Content-type": "application/json; charset=UTF-8"
//     }
// }).then(function (graph) {
//     console.log(graph);
// });

//     // if (error) throw error;
//

// });

function positionLink(d) {
    return "M" + d[0].x + "," + d[0].y
        + "S" + d[1].x + "," + d[1].y
        + " " + d[2].x + "," + d[2].y;
}

function positionNode(d) {
    return "translate(" + d.x + "," + d.y + ")";
}

function dragstarted(d) {
    if (!d3.event.active) simulation.alphaTarget(0.3).restart();
    d.fx = d.x, d.fy = d.y;
}

function dragged(d) {
    d.fx = d3.event.x, d.fy = d3.event.y;
}

function dragended(d) {
    if (!d3.event.active) simulation.alphaTarget(0);
    d.fx = null, d.fy = null;

}

/*var width = 960,
    height = 500
var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height);
var force = d3.layout.force()
    .gravity(0.05)
    .distance(100)
    .charge(-100)
    .size([width, height]);
d3.json("graph1.json", function(error, json) {
    if (error) throw error;
    force.nodes(json.nodes)
         .links(json.links)
         .start();
    var link = svg.selectAll(".link")
        .data(json.links)
        .enter().append("line")
        .attr("class", "link");
    var node = svg.selectAll(".node")
        .data(json.nodes)
        .enter().append("g")
        .attr("class", "node")
        .call(force.drag);
    node.append("image")
        .attr("xlink:href", "https://github.com/favicon.ico")
        .attr("x", -8)
        .attr("y", -8)
        .attr("width", 16)
        .attr("height", 16);
    node.append("text")
        .attr("dx", 12)
        .attr("dy", ".35em")
        .text(function(d) { return d.name });
    force.on("tick", function() {
        link.attr("x1", function(d) { return d.source.x; })
            .attr("y1", function(d) { return d.source.y; })
            .attr("x2", function(d) { return d.target.x; })
            .attr("y2", function(d) { return d.target.y; });
        node.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
    });
});*/

/*var canvas = document.querySelector("canvas"),
    context = canvas.getContext("2d"),
    width = canvas.width,
    height = canvas.height;
var simulation = d3.forceSimulation()
    .force("link", d3.forceLink().id(function(d) { return d.id; }).strength(0.5))
    .force("charge", d3.forceManyBody())
    .force("center", d3.forceCenter(width / 2, height / 2))
// .alphaDecay(0);
d3.select("input[type=range]")
    .on("input", inputted);
d3.json("graph.json", function(error, graph) {
    if (error) throw error;
    simulation
        .nodes(graph.nodes)
        .on("tick", ticked);
    simulation.force("link")
        .links(graph.links);
    function ticked() {
        context.clearRect(0, 0, width, height);
        context.beginPath();
        graph.links.forEach(drawLink);
        context.strokeStyle = "#aaa";
        context.stroke();
        context.beginPath();
        graph.nodes.forEach(drawNode);
        context.fill();
        context.strokeStyle = "#fff";
        context.stroke();
    }
});
function inputted() {
    simulation.force("link").strength(+this.value);
    simulation.alpha(1).restart();
}
function drawLink(d) {
    context.moveTo(d.source.x, d.source.y);
    context.lineTo(d.target.x, d.target.y);
}
function drawNode(d) {
    context.moveTo(d.x + 3, d.y);
    context.arc(d.x, d.y, 3, 0, 2 * Math.PI);
}*/

function testtest() {
    const name = document.getElementById('nameInput').value;
    const attributeName = document.getElementById('attributeNameInput').value;
    $.post("/getSocialGraphAndList", {name, attributeName}).done(
        response => {

            //Выводим список вершин графа
            const list = response.listOfSocialObjects;
            const listDiv = $("#listDiv");
             list.forEach(socialObject => {
                 listDiv.append(`<tr> <th scope="col">${socialObject.id} </td> <td>${socialObject.lastname} </td>
                                 <td>${socialObject.name} </td> <td>${socialObject.socialObjectGroup} </td> </tr>`);
        });


        const graph = JSON.parse(response.jsonSocialGraph);
    //    console.log(graph);
        var nodes = graph.nodes,
            nodeById = d3.map(nodes, function (d) {
                return d.id;
            }),
            links = graph.links,
            bilinks = [];

        links.forEach(function (link) {
            var s = link.source = nodeById.get(link.source),
                t = link.target = nodeById.get(link.target),
                i = {}; // intermediate node
            nodes.push(i);
            links.push({source: s, target: i}, {source: i, target: t});
            bilinks.push([s, i, t]);
        });

        var link = svg.selectAll(".link")
            .data(bilinks)
            .enter().append("path")
            .attr("class", "link");

        /*    var link = svg.selectAll(".link")
                .data(json.links)
                .enter().append("line")
                .attr("class", "link");*/

        var node = svg.selectAll(".node")
            .data(nodes.filter(function (d) {
                return d.id;
            }))
            .enter().append("circle")
            .attr("class", "node")
            .attr("r", 5)
            .attr("fill", function (d) {
                return color(d.group);
            })
            .call(d3.drag()
                .on("start", dragstarted)
                .on("drag", dragged)
                .on("end", dragended));

        /*       var node = svg.selectAll(".node")
                    .data(nodes.filter(function(d) { return d.id; }))
                    .enter().append("image")
                   .attr("xlink:href", "https://github.com/favicon.ico")
                   .attr("x", -8)
                   .attr("y", -8)
                   .attr("width", 16)
                   .attr("height", 16)
                   .attr("fill", function(d) { return color(d.group); })
                   .call(d3.drag()
                        .on("start", dragstarted)
                        .on("drag", dragged)
                        .on("end", dragended));*/

        node.append("text")
            .attr("dx", 12)
            .attr("dy", ".35em")
            .text(function (d) {
                return d.id
            });

        node.append("title")
            .text(function (d) {
                return d.id;
            });

        simulation
            .nodes(nodes)
            .on("tick", ticked);

        simulation.force("link")
            .links(links);

        function ticked() {
            link.attr("d", positionLink);
            node.attr("transform", positionNode);
        }
}
);
}