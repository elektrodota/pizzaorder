var items = [];

function bake_cookie(name, value) {
  var cookie = [name, '=', JSON.stringify(value), '; domain=.', window.location.host.toString(), '; path=/;'].join('');
  document.cookie = cookie;
}

function read_cookie(name) {
 var result = document.cookie.match(new RegExp(name + '=([^;]+)'));
 result && (result = JSON.parse(result[1]));
 return result;
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
    items.push(pizza);
    $('#itemCount').text(items.length).css('display', 'block');
    $("#shoppingCartItems").append(
  `
  <div data-id="${pizza.pizzaID}" data-list-id="${items.length}" class="row d-flex justify-content-between">
    <p class="col">${pizza.pizzaName}</p>
    <img class="col" src="${pizza.pizzaImage}"/>
    <p class="col">${pizza.pizzaSize}</p>
    <p class="col">${pizza.price}</p>
    <a class="removeFromCart col" href="#">X</a>
  </div>

  `);

    calculateTotalPrice(items);
}

function calculateTotalPrice(items){
    var price = 0;
    for(var i=0;i<items.length;i++)
    {
        price+=items[i].price;
    }
    if(items.length != 0)
    $("#totalPrice").text(price);
    else
    $("#totalPrice").text(0);
}

function findWithAttr(array, attr, value) {
    for(var i = 0; i < array.length; i += 1) {
        if(array[i][attr] == value) {
            return i;
        }
    }
    return -1;
}

//Document ready function
$(function () {
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
        let id = $(this).parent().attr("data-id");
        let indexToRemove = findWithAttr(items,'pizzaID',id);
        console.log(indexToRemove,id);
        if (indexToRemove > -1) {
          items.splice(indexToRemove, 1);
        }
        /*items = bake_cookie("items",items);*/
        $(this).parent().remove();
        $('#itemCount').text(items.length);
        calculateTotalPrice(items);
        if (items.length == 0) {
            $('#itemCount').css('display', 'none');
        }
    });
});