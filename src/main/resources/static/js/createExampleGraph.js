
function createExampleGraph() {
    const information = $("#information");
    $('label[id*=information]').text('');
    information.append(`<b>Идет обновление графа</b>`);
    const name = document.getElementById('nameInput').value;
    const attributeName = document.getElementById('attributeNameInput').value;
    const ratingCount = document.getElementById('ratingCount').value;
    $.post("/createExampleGraph", {name, attributeName, ratingCount}).done(
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
            var svg = d3.select("svg"),
                width = svg.attr("width"),
                height = svg.attr("height");

            svg.selectAll("*").remove();

            var force = d3.layout.force()
                .gravity(0.05)
                .distance(100)
                .charge(-100)
                .size([width, height]);


            const json = JSON.parse(response.jsonSocialGraph);
            console.log(json);

            // "Uncaught TypeError: Cannot read property 'weight' of undefined"
            json.links.forEach(function(link, index, list) {
                if (typeof json.nodes[link.source] === 'undefined') {
                    console.log('undefined source', link);
                }
                if (typeof json.nodes[link.target] === 'undefined') {
                    console.log('undefined target', link);
                }
            });

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
                .attr("r", 5)
                // .attr("fill", "#232db0")
                .call(force.drag);

            node.append("image")
            // .attr("xlink:href", "https://github.com/favicon.ico")
                .attr("xlink:href",function(d) {return d.photo;})
                .attr("x", -8)
                .attr("y", -8)
                .attr("width", 16)
                .attr("height", 16);

            node.append("text")
                .attr("dx", 12)
                .attr("dy", ".35em")
                .attr("fill", "#1d2030")
                .text(function(d) { return d.name });

            force.on("tick", function() {
                link.attr("x1", function(d) { return d.source.x; })
                    .attr("y1", function(d) { return d.source.y; })
                    .attr("x2", function(d) { return d.target.x; })
                    .attr("y2", function(d) { return d.target.y; });

                node.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
            });
            $('label[id*=information]').text('');
            information.append(`<b>Запрос выполнен</b>`)
        });
}