import React, {useState} from 'react';
import '../chat/Chat.css';
import {MessageObj} from "../../interfaces/MessageObj";
import avatar from "../../assets/avatar.webp";

function ChatBox(props: any) {
    const [messages, addMessage] = useState(props.messages);
    const [show, setShow] = useState(props.show);
    const [message, setMessage] = useState("");
    const m: MessageObj = {
        "index": 0,
        "guid": "542165d6-26d1-4b5e-bcf9-f48f246de297",
        "balance": "$2,436.66",
        "picture": "../../assets/avatar.webp",
        "name": props.name,
        "company": "ISOTERNIA",
        "email": "milessargent@isoternia.com",
        "phone": "+1 (960) 551-3865",
        "registered": "2014-02-05T05:13:22 -06:-30",
        "latitude": -19.86578,
        "longitude": 136.603294,
        "message": "",
        "favoriteFruit": "apple"
    };
    return (
        <div className="d-flex flex-column align-items-stretch flex-shrink-0 bg-white msger" style={{width: '60%'}}>
            <div className="msger-chat">
                <Message show={show} messages={messages} name={props.name}/>
            </div>

            <div className="msger-inputarea">
                <input type="text" className="msger-input" placeholder="Enter your message..."
                       onChange={(event) => {
                           setMessage(event.target.value);
                       }}/>
                <button type="submit" className="msger-send-btn" onClick={() => {
                    setShow(false);
                    m.message = message;
                    addMessage([...messages, m])
                    setShow(true);
                }
                }>Send
                </button>
            </div>
        </div>
    );
}

function Message(props: any) {
    const messages: any[] = props.messages;
    return (
        <>
            {props.show && messages.map((_, index) => (
                _.name.match(props.name) ?

                    <div className="msg right-msg" key={index}>
                        <div className="msg-img" style={{backgroundImage: `url(${avatar})`}}/>

                        <div className="msg-bubble">
                            <div className="msg-info">
                                <div className="msg-info-name">{_.name}</div>
                                <div className="msg-info-time">12:45</div>
                            </div>
                            <div className="msg-text">
                                {_.message}
                            </div>
                        </div>
                    </div>
                    :
                    <div className="msg left-msg" key={index}>
                        <div className="msg-img" style={{backgroundImage: `url(${avatar})`}}/>

                        <div className="msg-bubble">
                            <div className="msg-info">
                                <div className="msg-info-name">{_.name}</div>
                                <div className="msg-info-time">12:45</div>
                            </div>
                            <div className="msg-text">
                                {_.message}
                            </div>
                        </div>
                    </div>
            ))}
        </>);
}

export default ChatBox;
