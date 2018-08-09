<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<style> .error {color:red;} </style>

<section id="content">
	<div class="container">
		<div class="form">
			<form:form method="post" modelAttribute="articleRegistrationModel">
				<div class="form-row">
				
					<div id="category" class="form-group">
						<form:select class="form-control" path="category" name="category">
							<form:options items="${category }" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
					
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<form:input path="title" type="text" class="form-control" placeholder="제목을 입력하세요."/>
						<form:errors path="title" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<textarea name="contents" class="form-control" rows="10" placeholder="내용을 입력해주세요.">${articleRegistrationModel.contents }</textarea>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<input type="submit" class="btn pull-right" value="저장">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</section>

<script>
/* $(function () {
    var chatBox = $('.chat_box');
    var messageInput = $('input[name="message"]');
    var sendBtn = $('.send');
    var roomId = $('.content').data('room-id');
    var member = $('.content').data('member');

    // handshake
    var sock = new SockJS("/ws/chat");

    // onopen : connection이 맺어졌을 때의 callback
    sock.onopen = function () {
        // send : connection으로 message를 전달
        // connection이 맺어진 후 가입(JOIN) 메시지를 전달
        sock.send(JSON.stringify({chatRoomId: roomId, type: 'JOIN', writer: member}));
        
        // onmessage : message를 받았을 때의 callback
        sock.onmessage = function (e) {
            var content = JSON.parse(e.data);
            chatBox.append('<li>' + content.message + '(' + content.writer + ')</li>')
        }
    }

    sendBtn.click(function () {
        var message = messageInput.val();
        sock.send(JSON.stringify({chatRoomId: roomId, type: 'CHAT', message: message, writer: member}));
        messageInput.val('');
    });
}); */
</script>

