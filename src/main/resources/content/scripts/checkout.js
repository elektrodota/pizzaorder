var items=[];
function appendCheckout(item)
{
    var pizza=item.pizza;
    str= ' <li class="list-group-item d-flex justify-content-between lh-condensed">\n' +
        '                            <div>\n' +
        '                                <h6 class="my-0">'+pizza.pizzaName+ '<span title="jöhet ide dinamikusan akár hogy hány centi a pizza"> '+pizza.pizzaSize+' </span></h6>\n' +
        '                                <small class="text-muted">Tele van sajttal baszod mit nem értesz vegyél mást is te zsidó</small>\n' +
        '                            </div>\n' +
        '                            <span class="text-muted">'+pizza.price+'</span>\n' +
        '        </li>';
    $("#cart").append(str

    );
}
function appendPrice(items)
{
    str= '<li className="list-group-item d-flex justify-content-between">\n' +
        '        <span>Összesen:</span>\n' +
        '        <strong> '+calculateTotalPrice(items) +' Ft </strong>\n' +
        '    </li>'
    $("#cart").append(str

    );
}
$(function () {
    var json_str = getCookie('items');
    if(json_str.length!=0)
    {

        items = JSON.parse(json_str);
        console.log(items);
        for (var i=0;i<items.length;i+=1)
            appendCheckout(items[i]);
        appendPrice(items);
    }

});