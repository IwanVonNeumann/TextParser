/**
 * Created by ivans.ruskevics on 04.06.2015.
 */

function fileInputOnChange() {
    
    var uploadButton = $("#upload-button");

    if ($("#file-upload").val()) {
        uploadButton.removeClass("disabled");
    } else {
        uploadButton.addClass("disabled");
    }
}
