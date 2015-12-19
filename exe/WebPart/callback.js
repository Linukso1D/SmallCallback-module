  var ip='http://192.168.2.86:6662';
    $('#callmetoo').load(ip+' #lol');
    $('body').delegate('#lol', 'submit', function(e) {
        e.preventDefault();
        var th = $(this);
        
        $.ajax({
            url: ip+'?phone='+th.find('input[name=phone]').val(),
            success: function (html) {
                alert('Успешно');
            },
            error: function() {
                alert('error!');
            }
        });
        
        return false;
    });