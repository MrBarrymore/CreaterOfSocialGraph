
function testtest() {
    const name = document.getElementById('nameInput').value;
    const attributeName = document.getElementById('attributeNameInput').value;
    $.post("/getSocialGraphAndList", {name, attributeName}).done(
        response => {

            //Выводим список вершин графа
            const list = response.listOfSocialObjects;
            const listDiv = $("#listDiv");
            list.forEach(socialObject => {
                listDiv.append(`<tr> 
                                <th scope="col">${socialObject.inId}</th> 
                                <td><b> ${socialObject.lastname} ${socialObject.name}</b></td>
                                <td> ${socialObject.city} </td>
                                <td> <a href = ${socialObject.pageLink} > ${socialObject.pageLink}</a> </td> 
                                <td>${socialObject.friendsList.length} </td> 
                                <td>${socialObject.rating} </td> 
                                </tr>`);
            });


            // Визуализация социального графа
                var width = 960,
                    height = 500

                var svg = d3.select("body").append("svg")
                    .attr("width", width)
                    .attr("height", height);

                var force = d3.layout.force()
                    .gravity(0.05)
                    .distance(100)
                    .charge(-100)
                    .size([width, height]);

                // const json = JSON.parse(response.jsonSocialGraph);
                // console.log(graph);

                d3.json("graph1.json", function(error, json) {
                    if (error) throw error;
                    force
                        .nodes(json.nodes)
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
                        .text(function (d) {
                            return d.name
                        });

                    force.on("tick", function () {
                        link.attr("x1", function (d) {
                            return d.source.x;
                        })
                            .attr("y1", function (d) {
                                return d.source.y;
                            })
                            .attr("x2", function (d) {
                                return d.target.x;
                            })
                            .attr("y2", function (d) {
                                return d.target.y;
                            });

                        node.attr("transform", function (d) {
                            return "translate(" + d.x + "," + d.y + ")";
                        });
                    });
                });


        });
}




