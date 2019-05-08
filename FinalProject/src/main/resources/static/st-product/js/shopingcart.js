//Format VND
function formatCurrency(number) {

    var n = number.split('').reverse().join("");
    var n2 = n.replace(/\d\d\d(?!$)/g, "$&.");
    return n2.split('').reverse().join('');
}

//define orders[]
var orders = [];
var product = {
    productId: null,
    productName: null,
    price: 0,
    quantity: 1,
    orderItemId: null,
};
var tempProductList = [];

//load orders from local storage to display on cart when windown reload
// $(document).ready(function () {
//     if (localStorage.getItem("orders") != "[]" && localStorage.getItem("orders")) {
//         displayOrdersToCart();
//         console.log("Cart > 1");
//     } else {
//         productService.default();
//     }
//
// });
//send product to extra modal
function sendToModal(productId, productName, price) {


    //remove all items in tempProductList
    if (tempProductList.length > 0) {
        tempProductList = [];
    }


    //binding data for product
    product.productId = productId;
    product.productName = productName;
    product.price = price;

    //add product to tempProductList
    tempProductList.push(Object.assign(product));

    product = {};
    addToCart();
};

//initProduct when user click to '+ ADD' button
function initExtraProduct(productId, productName, price, seoName, cateName, masterId, disPercent, quantity) {
    //binding data for product
    product.productId = productId;
    product.productName = productName;
    product.price = price;
    product.quantity = tempProductList[0].quantity;


    //add product to tempProductList
    if (productService.isExistingProductTempProductList(product) == true) {//extra product existed
        productService.deleteProductInTempProductList(product);
        $("#green-tick-" + productId).hide();

    } else {//add new extra product
        tempProductList.push(Object.assign(product));
        $("#green-tick-" + productId).show();

    }

    product = {};
}

//create generalId of order in cart
function generalId() {
    var orderItemId = "";
    for (var i = 0; i < tempProductList.length; i++) {
        orderItemId += tempProductList[i].productId;
    }
    return orderItemId;
};

//add item to cart
function addToCart() {
    var quantity = 1;
    tempProductList[0].quantity = 1;
    for (var i = 1; i < tempProductList.length; i++) {
        tempProductList[i].quantity = quantity;
    }
    var orderItemId = generalId();
    productService.addProductToCart(tempProductList, orderItemId);
    productService.ResetTotalPrice();
}

function changeProductQuantity(isPlus, orderItemId) {
    var orders = getProductsByOrderItemId(orderItemId);

    if (orders != null) {
        for (var i = 0; i < orders.length; i++) {
            orders[i].quantity = 1;
        }
        if (isPlus) {
            productService.addQuantityOrderItem(orderItemId);
        } else {

            productService.removeQuantityOrderItem(orderItemId);

        }
    }

    productService.saveOrderItemToLocalStorage(orders);
    productService.ResetTotalPrice();
}

//Delete OrderItem by OrderItemId from LocalStorage
function deleteOrderItem(orderItemId) {
    productService.deleteOrderItembyId(orderItemId);
}

//iterate orderItem in orders to Shopping cart
function displayOrdersToCart() {
    if (localStorage.getItem("orders")) {
        var orders = productService.getOrdersFromLocalStorage('orders');
        // $('#totalcart').text(orders.length);
        var content = "";
        var hasExtraOrderItem = [];
        for (var i = 0; i < orders.length; i++) {
            var extra = "";
            var totalOrder = 0;
            var totalOrderItem = 0;
            if (orders[i].masterId == null) {
                totalOrderItem += orders[i].price;
                var masterProductIndex = i;
                content += "<div class='product-cart d-flex' id='orderItemId-" + orders[masterProductIndex].orderItemId + "'>"
                    + "<div class='one-forth'>"
                    + "<div class='display-tc'>"
                    + "<h3>" + orders[masterProductIndex].productName + "</h3>"
                    + "</div>"
                    + " </div>"
                    + "<div class='one-eight text-center'>"
                    + "<div class='display-tc'>"
                    + "<span class='price'>" + formatCurrency(orders[masterProductIndex].price.toString()) + "</span>"
                    + "</div>"
                    + "</div>"
                    + "<div class='one-eight text-center'>"
                    + "<div class='display-tc'>"
                    + "<button class='minus-btn quantity-counter-size' onclick='changeProductQuantity(false, " + orders[masterProductIndex].orderItemId + ")'>-</button>"
                    + " <span class='quantity'>" + orders[masterProductIndex].quantity + "</span>"
                    + "<button class='plus-btn quantity-counter-size' onclick='changeProductQuantity(true, " + orders[masterProductIndex].orderItemId + ")'>+</button>"
                    + "</div>"
                    + "</div>"
                    + " <div class='one-eight text-center'>"
                    + " <div class='display-tc'>"
                    + " <span class='totalpriceItem'>" + formatCurrency(totalOrderItem.toString()) + "</span>"
                    + "</div>"
                    + "</div>"
                    + "<div class='one-eight text-center'>"
                    + "<div class='display-tc'>"
                    + " <button class='closed' onclick='deleteOrderItem(" + orders[masterProductIndex].orderItemId + ")'></button>"
                    + "</div>"
                    + "</div>"
                    + "</div>"

                $("#shopping-cart-body").html(content);

                if (extra == "") {
                    hasExtraOrderItem.push(orders[masterProductIndex].orderItemId);
                }

            }
        }


        productService.ResetTotalPrice();
        for (var i = 0; i < hasExtraOrderItem.length; i++) {
            $("#orderItemId-" + hasExtraOrderItem[i] + " #hasExtra").css('display', 'none');
        }

        productService.ResetTotalPrice();


    }
}


/*
* author: TintH
* method: get order in cart by id
*/
function getOrderById(orderItemId) {
    var orders = productService.getOrdersFromLocalStorage('orders');
    for (var i = 0; i < orders.length; i++) {
        if (orders[i].orderItemId == orderItemId) {
            return orders[i];
        }
    }
    return null;
}

//Get Products list by OrderItemID
function getProductsByOrderItemId(orderItemId) {
    var orders = productService.getOrdersFromLocalStorage('orders');
    var result = [];
    for (var i = 0; i < orders.length; i++) {
        if (orders[i].orderItemId == orderItemId) {
            result.push(orders[i]);
        }
    }

    if (result.length > 0) {
        return result;
    }
    ;
    return null;
}

/*
* author: TinTH
* method: set order to cart
*/

function setOrderById(order) {
    var orders = productService.getOrdersFromLocalStorage('orders');
    for (var i = 0; i < orders.length; i++) {
        if (orders[i].orderItemId == order.orderItemId) {
            orders[i] = order;
        }
    }
}


var productService = {

    //binding varible to localStorage
    default: function () {
        if (productService.getOrdersFromLocalStorage('orders') == null) {
            productService.saveOrdersToLocalStorage('orders', orders);
        }
    },

    saveOrdersToLocalStorage: function (key, object) {
        //convert orders array to string form
        var objectstring = JSON.stringify(object);
        localStorage.setItem(key, objectstring);
        $('#totalcart').text(object.length);
    },


    getOrdersFromLocalStorage: function (key) {
        var objectstring = localStorage.getItem(key);
        //convert objectstring to javascript object
        return JSON.parse(objectstring);
    },

    getOrderByOrderItemId: function (orderItemId) {
        var order;
        var orders = productService.getOrdersFromLocalStorage('orders');
        for (var i = 0; i < orders.length; i++)
            if (orders[i].orderItemId == orderItemId) {
                //&& service.isSingleItem($localStorage.orders[i]))
                order = orders[i];
            }
        return order;
    },

    /*
    * method: Add given product to cart. Count up if product exist
    */
    addProductToCart: function (tempProductList, orderItemId) {
        if (tempProductList == null) {
            alert("Xin vui lòng thử lại. Cảm ơn!")
        } else {

            //set orderItemId for all items in tempProductList
            for (var i = 0; i < tempProductList.length; i++) {
                tempProductList[i].orderItemId = orderItemId;
            }

            //get existing orderItem
            var orderItem = productService.getExistingTempListInLocalStorage(orderItemId);

            if (orderItem != null) { //orderItem existeds
                orderItem.quantity += tempProductList[0].quantity;

                //Get All OrderItemList from LocalStorage
                var orders = productService.getOrdersFromLocalStorage("orders");
                //Remove OrderItem Existed by OrderItemId
                for (var i = 0; i < orders.length; i++) {
                    if (orders[i].orderItemId == orderItemId) {
                        orders.splice(i, tempProductList.length);
                        break;
                    }
                }
                //Add New Item to Orders.
                for (var i = 0; i < tempProductList.length; i++) {
                    tempProductList[i].quantity = orderItem.quantity;
                    orders.push(Object.assign(tempProductList[i]));
                }
                //Save to LocalStorage.
                productService.saveOrdersToLocalStorage('orders', orders);

                // //change HTML code in shopping cart
                // $("#orderItemId-" + orderItem.orderItemId).remove();

                //create new HMTL code and append to shopping cart
                totalShoppingcart = orders.length;
                $('#totalcart').text(totalShoppingcart);
                // var HTMLorderItem = productService.createHTMLOrderItem(tempProductList);
                // $("#shopping-cart-body").append(HTMLorderItem);

                //save to local storage
                //productService.saveOrderItemToLocalStorage(orderItem);

            } else { // New order
                // //append orderItem to HTMl cart
                // var HTMLorderItem = productService.createHTMLOrderItem(tempProductList);
                // $("#shopping-cart-body").append(HTMLorderItem);

                var orders = productService.getOrdersFromLocalStorage("orders");
                for (var i = 0; i < tempProductList.length; i++) {
                    orders.push(Object.assign(tempProductList[i]));
                }
                productService.saveOrdersToLocalStorage('orders', orders);
            }

        }

        orderItem = null;
        orderItem = null;
        tempProductList = [];
    },

    ResetTotalPrice: function () {
        var orders = productService.getOrdersFromLocalStorage("orders");
        totalShoppingcart = 0;
        for (var i = 0; i < orders.length; i++) {
            totalShoppingcart += orders[i].price * orders[i].quantity;
        }
        $('#totalprice').html(formatCurrency(totalShoppingcart.toString()));
    },

    saveOrderItemToLocalStorage: function (orderItem) {
        var orders = productService.getOrdersFromLocalStorage("orders");
        for (var i = 0; i < orders.length; i++) {
            if (orders[i].orderItemId == orderItem.orderItemId) {
                orders.splice(i, 1);
                orders.push(orderItem);
                break;
            }
        }
        productService.saveOrdersToLocalStorage("orders", orders);
    },

    //get extra Product in tempProductList if it existed
    isExistingProductTempProductList: function (extraProduct) {
        var result = false;
        for (var i = 0; i < tempProductList.length; i++) {
            if (tempProductList[i].productId == extraProduct.productId) {
                result = true;
                break;
            }
        }
        return result;
    },

    //delete existing extra product in tempProductList
    deleteProductInTempProductList: function (extraProduct) {
        for (var i = 0; i < tempProductList.length; i++) {
            if (tempProductList[i].productId == extraProduct.productId) {
                tempProductList.splice(i, 1);
            }
        }
    },

    /*
    * author: TinTH
    * method: Create a div to from orderItem
    */

    createHTMLOrderItem: function (tempProductList) {
        var totalOrderItem = 0;
        totalOrderItem += tempProductList[0].price;
        var content =
            "<div id='orderItemId-" + tempProductList[0].orderItemId + "'>"
            + "<div class='row'>"
            + "<div class='col-sm-6 pull-left'>"
            + "<span class='subcategory'> " + tempProductList[0].cateName + "<br> </span>"
            + "</div>"
            + "<div class='col-sm-6 text-right' onclick='deleteOrderItem(" + tempProductList[0].orderItemId + ")'>"
            + "<i>"
            + "<p class='section-header glyphicon glyphicon-remove' style = 'cursor: pointer; margin-bottom: 0' ><span><i class='' aria-hidden='true'></i></span></p>"
            + "</i>"
            + "</div>"
            + "</div>"

            + "<div class='row' style='display: flex; align-items: center' id='showExtra'>"
            + "<div class='col-sm-12 col-md-8 col-xs-9'>"
            + "<div>"
            + "<h3 id=" + tempProductList[0].productId + ">"
            + "<span class='description'>"
            + "<i class='fa fa-plus' id='hasExtra' aria-hidden='true' onclick='showExtra1(" + tempProductList[0].orderItemId + ")'>"
            + "</i>"
            + "<i class='fa fa-minus' aria-hidden='true' style='display: none'>"
            + "</i> &nbsp;"
            + "</span>"
            + tempProductList[0].productName + " &nbsp;"
            + "<img ng-src='images/veg.62b68100.png' alt='' class='veg-image' src='images/veg.62b68100.png'>"
            + "<div style='display: none; font-size: 10px; font-weight: 400; line-height: 1.5'> [BOX] Gulab Jamun </div>"
            + "</h3>"
            + "</div>"
            + "</div>"
            + "<div class='col-md-4 text-right'>"
            + formatCurrency(tempProductList[0].price.toString())
            + "</div>"
            + "</div>"

            + extra

            + "<div class='row'>"
            + "<div class='col-sm-6 text-left ng-binding' style='float:left'>"
            + "<span class='ng-scope'>"
            //+ "<span class='strikethrough'>₹&nbsp;216&nbsp;</span>&nbsp;"
            + "</span >" + formatCurrency(totalOrderItem.toString())
            + "</div >"
            + "<div class='col-sm-6 text-right' style='float:right'>"
            + "<div class='red-counter sidecart-counter'>"
            + "<a class='minus-btn quantity-counter-size' onclick='changeProductQuantity(false, " + tempProductList[0].orderItemId + ")'>-</a>"
            + "<span class='quantity'>" + tempProductList[0].quantity + "</span>"
            + "<a class='plus-btn quantity-counter-size' onclick='changeProductQuantity(true, " + tempProductList[0].orderItemId + ")'>+</a>"
            + "</div>"
            + "</div>"
            + "</div>"
            + "<error-msg-builder unavailable-items='unavailable_items' item='item'>"
            + "<p class='custom-error-text'>"
            + "</p>"
            + "</error-msg-builder>"
            + "</div>";


        return content;
    },


    /*
    * author: TinTH
    * method: Get order list in localstorage
    */
    getOrders: function () {
        return productService.getOrdersFromLocalStorage('orders');
    },

    /*
    * method: [Private] Get the existing product
    * params: {Number} product
    * return: {Number} The existing product in localStorage. Return null if product not found.
    */
    getExistingTempListInLocalStorage: function (orderItemId) {
        var result = null;
        var orders = productService.getOrdersFromLocalStorage('orders');
        for (var i = 0; i < orders.length; i++)
            if (orders[i].orderItemId == orderItemId) {
                result = orders[i];
                break;
            }
        return result;
    },

    addQuantityOrderItem: function (orderItemId) {
        var orderItemList = getProductsByOrderItemId(orderItemId);
        //Get All OrderItemList from LocalStorage
        var orders = productService.getOrdersFromLocalStorage("orders");
        //Remove OrderItem Existed by OrderItemId
        for (var i = 0; i < orders.length; i++) {
            if (orders[i].orderItemId == orderItemId) {
                orders.splice(i, orderItemList.length);
                break;
            }
        }
        //Add Product Quantity.
        for (var i = 0; i < orderItemList.length; i++) {
            orderItemList[i].quantity++;
            orders.push(Object.assign(orderItemList[i]));
        }
var totalPriceItem = orderItemList[0].quantity * orderItemList[0].price;
        $("#orderItemId-" + orderItemId + " span.totalpriceItem").text(totalPriceItem);
        $("#orderItemId-" + orderItemId + " span.quantity").text(orderItemList[0].quantity);

        productService.ResetTotalPrice();
        //Save to LocalStorage.
        productService.saveOrdersToLocalStorage('orders', orders);
    },

    //Remove OrderItem from Data
    removeQuantityOrderItem: function (orderItemId) {
        var priceOrderItem = 0;
        var orderItemList = getProductsByOrderItemId(orderItemId);
        //Get All OrderItemList from LocalStorage
        var orders = productService.getOrdersFromLocalStorage("orders");
        //Remove OrderItem Existed by OrderItemId

        for (var i = 0; i < orders.length; i++) {
            if (orders[i].orderItemId == orderItemId) {
                orders.splice(i, orderItemList.length);
                break;
            }
        }
        if (orderItemList[0].quantity > 1) {
            //Add New Item to Orders.
            for (var i = 0; i < orderItemList.length; i++) {
                orderItemList[i].quantity--;
                orders.push(Object.assign(orderItemList[i]));
            }
            var totalPriceItem = orderItemList[0].quantity * orderItemList[0].price;
            $("#orderItemId-" + orderItemId + " span.totalpriceItem").text(totalPriceItem);
            $("#orderItemId-" + orderItemId + " span.quantity").text(orderItemList[0].quantity);
            //change HTML code in shopping cart
            //$("#orderItemId-" + orderItemId).remove();

            ////create new HMTL code and append to shopping cart

            //var HTMLorderItem = productService.createHTMLOrderItem(orderItemList);
            //$("#shopping-cart-body").append(HTMLorderItem);

            //Save to LocalStorage.
            productService.saveOrdersToLocalStorage('orders', orders);
            productService.ResetTotalPrice();
            if (localStorage.getItem('orders') && localStorage.getItem('orders') == "[]") {
                $("body").removeClass("resize-screen");
                SmoothlyMenu();
            }
        } else {
            //change HTML code in shopping cart
            swal({
                title: "Bạn có muốn xóa sản phẩm này không?",

                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Xóa",
                cancelButtonText: "Thoát",
            }, function () {
                $("#orderItemId-" + orderItemId).remove();
                //Save to LocalStorage.
                productService.saveOrdersToLocalStorage('orders', orders);
                productService.ResetTotalPrice();
                if (localStorage.getItem('orders') && localStorage.getItem('orders') == "[]") {
                    $("body").removeClass("resize-screen");
                    SmoothlyMenu();
                }
            });

        }
    },

    deleteOrderItembyId: function (orderItemId) {
        var orders = productService.getOrdersFromLocalStorage("orders");
        var orderItemList = getProductsByOrderItemId(orderItemId);
        swal({
            title: "Bạn có muốn xóa sản phẩm này không?",

            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Xóa",
            cancelButtonText: "Thoát",
        }, function () {
            for (var i = 0; i < orders.length; i++) {
                if (orders[i].orderItemId == orderItemId) {
                    orders.splice(i, orderItemList.length);
                    break;
                }
            }

            //Delete HTML code in shopping cart
            $("#orderItemId-" + orderItemId).remove();

            //Save to LocalStorage.
            productService.saveOrdersToLocalStorage('orders', orders);
            productService.ResetTotalPrice();
            if (localStorage.getItem('orders') && localStorage.getItem('orders') == "[]") {
                $("body").removeClass("resize-screen");
                SmoothlyMenu();
            }
        });


    }
};