var items = [];
var createCookie = function(name, value, days) {
    var expires;
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = "; expires=" + date.toGMTString();
    }
    else {
        expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}

function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) {
                c_end = document.cookie.length;
            }
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}
function deleteCookie( name ) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function getPizza(id,size) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/shoppingCartController/api/getPizza",
        data: {
        "id":id,
        "size":size
        },
        success: function (data) {
            console.log("SUCCESS: ", data);
            addToCart(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        complete : function(){
            console.log(this.url);
        }
    });
}

function addToCart(pizza)
{
    /*if (read_cookie("items") != "undefined") {
        items = bake_cookie("items",items);
    }*/
    var uniqueId = function() {
        return 'id-' + Math.random().toString(36).substr(2, 16);
    };
    itemid=uniqueId();
    item={itemid ,pizza};
    items.push(item);
    var json_str = JSON.stringify(items);
    deleteCookie('items')
    createCookie('items', json_str);
    console.log(getCookie('items'));
    $('#itemCount').text(items.length).css('display', 'block');
    appendShoppingCart(item);

    $("#totalPrice").text(calculateTotalPrice(items));
}
function appendShoppingCart(item)
{

    pizza=item.pizza;
    itemid=item.itemid;
    $("#shoppingCartItems").append(
        `
  <div data-id="${pizza.pizzaID}" data-list-id="${items.length}" item-id="${itemid}" class="row">
    <img class="col-sm-3" src="${pizza.pizzaImage}"/>
    <p class="col-sm-3">${pizza.pizzaName}</p>
    <p class="col-sm-3">${pizza.pizzaSize}</p>
    <p class="col-sm-2">${pizza.price}</p>
    <a class="removeFromCart col-sm-1" href="#">X</a>
  </div>

  `);
}
function calculateTotalPrice(items){
    var price = 0;
    for(var i=0;i<items.length;i++)
    {
        price+=items[i].pizza.price;
    }
    if(items.length != 0)
     return price;
    else
        return 0;

}

function findWithAttr(array, attr, value) {
    for(var i = 0; i < array.length; i += 1) {
        if(array[i][attr] == value) {
            return i;
        }
    }
    return -1;
}

function goToCheckOut(){
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/Checkout",

        success: function () {
            window.location=this.url;


        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        complete : function(){
            console.log(this.url);
        }
    });
}
//Document ready function
$(function () {
    var json_str = getCookie('items');
    if(json_str.length!=0)
    {

        items = JSON.parse(json_str);
        $('#itemCount').text(items.length).css('display', 'block');
        console.log(items);
        for (var i=0;i<items.length;i+=1)
            appendShoppingCart(items[i]);
    }
    // Add Item to Cart
    $('.addToCart').click(function (event) {
        event.preventDefault();
        let id = $(this.closest(".card")).attr("data-id");
        let size = $(this.closest(".card")).find("select").val();
        getPizza(id,size);
    });
    // Remove Item From Cart
    $('#shoppingCartModal').on('click', '.removeFromCart', function () {
        event.preventDefault();
        console.log($(this).parent());
        let id = $(this).parent().attr("item-id");
        let indexToRemove = findWithAttr(items,'itemid',id);
        console.log(indexToRemove,id);
        if (indexToRemove > -1) {
          items.splice(indexToRemove, 1);
        }
        /*items = bake_cookie("items",items);*/
        $(this).parent().remove();
        $('#itemCount').text(items.length);
        $("#totalPrice").text(calculateTotalPrice(items));
        var json_str = JSON.stringify(items);
        createCookie('items', json_str);
        if (items.length == 0) {
            $('#itemCount').css('display', 'none');
        }
    });

    $('#goToCheckout').on('click',goToCheckOut);
});