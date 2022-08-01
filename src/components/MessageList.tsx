import React from 'react';
import './App.css';
import  messages from '../assets/messages.json';
function MessageList() {
    return (
            <div className="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style={{width:'30%'}}>
                <div className="list-group list-group-flush border-bottom scrollarea">
                    <a className="list-group-item list-group-item-action active py-3 lh-sm"
                       aria-current="true">
                        <div className="d-flex w-100 align-items-center justify-content-between">
                            <strong className="mb-1">List group item heading</strong>
                            <small>Wed</small>
                        </div>
                        <div className="col-10 mb-1 small">Some placeholder content in a paragraph below the
                            heading
                            and date.
                        </div>
                    </a>
                    {messages.map((_, index) => (
                        <a className="list-group-item list-group-item-action  py-3 lh-sm"
                           aria-current="true">
                            <div className="d-flex w-100 align-items-center justify-content-between">
                                <strong className="mb-1">{_.name}</strong>
                                <small>Wed</small>
                            </div>
                            <div className="col-10 mb-1 small">{_.message}
                            </div>
                        </a>
                    ))}
                </div>
            </div>
    );
}

export default MessageList;
