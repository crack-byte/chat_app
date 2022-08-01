import React from 'react';
import './App.css';
import {Button, Form, InputGroup} from "react-bootstrap";
import {FiSend} from "react-icons/fi";

function Chat() {
    return (
        <div className="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style={{width: '50%'}}>
            <div className="list-group list-group-flush border-bottom scrollarea" style={{height: '95%'}}>
                <a className="list-group-item list-group-item-action active py-3 lh-sm"
                   aria-current="true">
                    <div className="col-10 mb-1 small">Some placeholder content in a paragraph below the
                        heading
                        and date.
                    </div>
                </a>
                {Array.from({length: 50}).map((_, index) => (
                    <a className="list-group-item list-group-item-action  py-3 lh-sm"
                       aria-current="true">
                        <div className="col-10 mb-1 small">Some placeholder content in a paragraph below the
                            heading
                            and date.
                        </div>
                    </a>
                ))}
            </div>
            <div className="align-items-bottom" style={{height: '5%'}}>
                <InputGroup>
                    <Form.Control
                        placeholder=""
                        aria-label=""
                    />
                    <Button variant="outline-secondary"><FiSend/></Button>
                </InputGroup>
            </div>
        </div>
    );
}

export default Chat;
