var socket = new WebSocket("ws://127.0.0.1:6661");
socket.onopen = function() {
  alert("Соединение установлено.");
};
socket.send('Call:{Name:\"MyName\",Phone:\"+380983486598\"}');
socket.onclose = function(event) {
  if (event.wasClean) {
    alert('Соединение закрыто чисто');
  } else {
    alert('Обрыв соединения'); 
  }
  alert('Код: ' + event.code + ' причина: ' + event.reason);
};

socket.onmessage = function(event) {
  alert("Получены данные " + event.data);
};

socket.onerror = function(error) {
  alert("Ошибка " + error.message);
};



           