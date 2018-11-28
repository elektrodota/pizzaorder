function setCookie(cname, cvalue, extradays) {
    var d = new Date();
    d.setTime(d.getTime() + (extradays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
function getPizza(id) {
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/shoppingController/api/getPizza",
        data : id,
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            return data;
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}
//Document ready function
$(function(){
var items = [];
if(getCookie(items)!="")
{
    items=getCookie(items);
}
var priceTotal;

// Add Item to Cart
$('.addToCart').click(function (){
  let id = $(this.closest(".card")).attr("id");
  let size = $(this.closest(".card")).find("select").val();
  items.push({pizzaID:id,pizzaSize:size});
  setCookie("items",items,1);



  $("#shoppingCartItems").append("<li></li>")

  $('#itemCount').text(items.length).css('display', 'block');

  priceTotal += price;
});

// Remove Item From Cart
$('#shoppingCartModal').on('click', '.removeFromCart', function(){

  items.splice(,1)
  $('#itemCount').text(items.length);

  // Remove Cost of Deleted Item from Total Price
  var price = parseInt($(this).siblings().find('.price').text());
  priceTotal -= price;

  if (itemCount == 0) {
    $('#itemCount').css('display', 'none');
  }
});

});