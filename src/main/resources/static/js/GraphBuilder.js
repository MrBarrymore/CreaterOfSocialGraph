
function testtest() {
    const name = document.getElementById('nameInput').value;
    const attributeName = document.getElementById('attributeNameInput').value;
    console.log(name, attributeName);
    $.post("/getSocialGraphAndList", {name, attributeName}).done(
        response => {

            // Выводим список вершин графа
            const list = response.listOfSocialObjects;
            const listDiv = $("#listDiv");
            list.forEach(socialObject => {
                listDiv.append(`<div><b>${socialObject.id}</b><span>${socialObject.lastname}</span><span> ${socialObject.name}</span><span>${socialObject.socialObjectGroup}</span></div>`);
            });

            // Рисуем социальный граф
            const graph = JSON.parse(response.jsonSocialGraph);
      //      console.log(graph);


            var nodes = graph.nodes,
                nodeById = d3.map(nodes, function (d) {
                    return d.id;
                }),
                links = graph.links,
                bilinks = [];

/*            links.forEach(function (link) {
                var s = link.source = nodeById.get(link.source),
                    t = link.target = nodeById.get(link.target),
                    i = {}; // intermediate node
                nodes.push(i);
                links.push({source: s, target: i}, {source: i, target: t});
                bilinks.push([s, i, t]);
            });*/

           var link = svg.selectAll(".link")
                .data(bilinks)
                .enter().append("path")
                .attr("class", "link");

/*                var link = svg.selectAll(".link")
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


            node.append("text")
                .attr("dx", 12)
                .attr("dy", ".35em")
                .text(function (d) {
                    return d.id
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
