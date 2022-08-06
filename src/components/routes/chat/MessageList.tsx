import React, {useEffect, useState} from 'react';
import DivideVr from "../../Divide";
import ChatBox from "./ChatBox";
import '../../App.css';
import '../../../components/routes/chat/Chat.css';
import personalMessages from '../../../assets/personal_messages.json';
import axios from "axios";
import {
    useSubscription,
} from "react-stomp-hooks";

const weekday = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

function MessageList() {
    let itemClasses = ['list-group-item', 'list-group-item-action', 'py-3', 'lh-sm'].join(' ');
    let activeItemClasses = ['list-group-item', 'list-group-item-action', 'py-3', 'active', 'lh-sm'].join(' ');
    const d = new Date();
    const day = weekday[d.getDay()];
    const [show, setShow] = useState(true);
    const [active, setActive] = useState(0);
    const [messages, setMessage] = useState([]);
    useEffect(() => {
        axios.get('http://localhost:8080/chats/recent')
            .then(function (response) {
                setMessage(response.data.data);
            });
    }, [show]);
    return (
        <>
            <div className="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style={{width: '30%'}}>
                <div
                    className="list-group list-group-flush border-bottom d-flex w-100 align-items-center justify-content-between">
                    <h2>ChatRooms</h2>
                </div>
                <div className="list-group list-group-flush border-bottom scrollarea">
                    {messages.length > 0 && messages.map((_: any, index: any) => (
                        <div key={index.toString()}>
                            <a className={index === active ? activeItemClasses : itemClasses}
                               aria-current="true" onClick={() => {
                                setShow(false);
                                setActive(index);
                                setShow(true);
                            }}>
                                <div className="d-flex align-items-center justify-content-between "
                                     style={{width: '90%'}}>
                                    <strong className="mb-1">{_.name}</strong>
                                    <small>{day}</small>
                                </div>
                                <div className="col-10 mb-1 small">{_.message}
                                </div>
                            </a>
                        </div>
                    ))}
                </div>
            </div>
            <DivideVr/>
            <ChatBox key={active} show={show} name="Admin"/>
        </>
    );
}

export default MessageList;
