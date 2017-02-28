<!DOCTYPE html>
<html>
<head>
    <title>Realtime Guestbook</title>
</head>
<body>
<div>
    <p>Write a message:</p>
    <textarea id="message"></textarea>
    <button type="button" id="send">Send</button>
</div>
<div>
    <h3>Messages:</h3>
    <ol id="messages"></ol>
</div>

<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        var messageList = $("#messages");

        var getMessageString = function(message) {
            var date = new Date(message.date);
            return "<li><p>Received: " + date + "</p><div>" + message.content + "</li>";
        };

        var url = 'ws://192.168.21.138:12306/xiaots';
        var stompClient = Stomp.client(url);
        stompClient.connect({ }, function(frame) {
            // subscribe to the /topic/entries endpoint which feeds newly added messages
            stompClient.subscribe('/topic/test/send', function(data) {
                // when a message is received add it to the end of the list
                var body = data.body;
                var message = JSON.parse(body);
                messageList.append(getMessageString(message));
            });
        });

        $("#send").on("click", function() {
            // send the message
            stompClient.send("/topic/test/send", {}, $("#message").val());
            $("#message").val("");
        });
    });
</script>
</body>
</html>
