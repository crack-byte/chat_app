import React, {useState} from 'react';
import '../chat/Chat.css';
import DivideVr from "../Divide";
import ChatBox from "./ChatBox";
import '../App.css';
import messages from '../../assets/messages.json';
import personalMessages from '../../assets/personal_messages.json';

function MessageList() {
    let itemClasses = ['list-group-item', 'list-group-item-action', 'py-3', 'lh-sm'].join(' ');
    let activeItemClasses = ['list-group-item', 'list-group-item-action', 'py-3', 'active', 'lh-sm'].join(' ');
    const [active, setActive] = useState(0);
    const [show, setShow] = useState(false);
    return (
        <>
            <div className="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style={{width: '30%'}}>
                <div className="list-group list-group-flush border-bottom scrollarea">
                    {messages.map((_, index) => (
                        <div key={index.toString()}>
                            <a className={index === active ? activeItemClasses : itemClasses}
                               aria-current="true" onClick={() => {
                                setShow(false);
                                setActive(index);
                                setShow(true);
                            }}>
                                <div className="d-flex w-100 align-items-center justify-content-between">
                                    <strong className="mb-1">{_.name}</strong>
                                    <small>Wed</small>
                                </div>
                                <div className="col-10 mb-1 small">{_.message}
                                </div>
                            </a>
                        </div>
                    ))}
                </div>
            </div>
            <DivideVr/>
            <ChatBox key={active} show={show} messages={personalMessages.at(active)} name={messages[active].name}/>
        </>
    );
}

export default MessageList;
