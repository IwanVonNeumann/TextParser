/**
 * Created by ivans.ruskevics on 04.06.2015.
 */

function uploadButtonOnClick() {

    var fileInput = $("#file-upload");

    if (fileInput.val()) {
        var formData = new FormData($("#upload-form")[0]);
        $.ajax({
            url: 'text',
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false
        }).success(function (response) {
            if (response.successful) {
                loadData(response);
                console.log(response.message);
            } else {
                alert(response.message);
            }
        });
    }

    fileInput.replaceWith(fileInput = fileInput.clone(true));
    $("#upload-button").addClass("disabled");
}
