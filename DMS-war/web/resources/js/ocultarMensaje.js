/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).on("pfAjaxComplete", function () {
    setTimeout(function () {
        $('.ocultar').slideUp(650);
    }, 5000);
});
