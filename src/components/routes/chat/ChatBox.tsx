import React, {useEffect, useState} from 'react';
import '../../routes/chat/Chat.css';
import avatar from "../../../assets/avatar.webp";
import {useSubscription} from "react-stomp-hooks";
import axios from "axios";

const rightMsgClassNames = ['msg', 'right-msg'].join(' ')
const leftMsgClassNames = ['msg', 'left-msg'].join(' ')

function send(message: any) {
    axios.post('http://localhost:8080/chat/send',message)
        .then(function (response) {
        });
}

function ChatBox(props: any) {
    const [messages, addMessage]: any = useState([]);
    const [message, setMessage] = useState("");
    const chatRoom = props.chatRoom;
    const channel = "/room/"+String(props.chatRoom?.uuid)
    const scrollToBottom = () => {
        const element = document.getElementById(String(messages.length - 1));
        if (element != null) {
            element.scrollIntoView({behavior: "smooth", block: "end", inline: "end",});
        }
    }
    useSubscription(channel, (m) => {
        const m1 = JSON.parse(m.body);
        console.log(m1)
        addMessage([...messages, m1])
    });
    useEffect(() => {
        scrollToBottom()
    }, [messages]);

    return (
        <div className="d-flex flex-column align-items-stretch flex-shrink-0 bg-white msger" style={{width: '63%'}}>
            <div className="msger-chat">
                {props.show && messages.map((_: any, index: any) => (
                    <Message show={true} message={_} name={props.name} sender="00c99d61-6d38-478c-a05b-06790721cff2" index={index}/>
                ))}
                <div id="end"/>
            </div>

            <div className="msger-inputarea">
                <input type="text" className="msger-input" placeholder="Enter your message..."
                       value={message}
                       onChange={(e) => {
                           setMessage(e.target.value)
                       }}
                />
                <button type="submit" className="msger-send-btn" onClick={() => {
                    if (message.length > 0) {
                        send({
                            "message":message,
                            "sender":"00c99d61-6d38-478c-a05b-06790721cff2",
                            "receiver":chatRoom.uuid,
                            "timestamp":new Date().getTime()
                        })
                        setMessage('');
                    }
                }}>Send
                </button>
            </div>
        </div>
    );
}

function Message(props: any) {
    const _ = props.message;
    return (
        <div className={_.sender.match(props.sender) ? rightMsgClassNames : leftMsgClassNames} key={props.index}
             id={props.index}>
            <div className="msg-img" style={{backgroundImage: `url(${avatar})`}}/>
            <div className="msg-bubble">
                <div className="msg-info">
                    <div className="msg-info-name">{_.sender}</div>
                    <div className="msg-info-time">12:45</div>
                </div>
                <div className="msg-text" style={{overflowWrap: 'break-word'}}>
                    {_.message}
                </div>
            </div>
        </div>
    );
}

export default ChatBox;
