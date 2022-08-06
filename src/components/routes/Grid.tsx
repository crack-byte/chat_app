import DivideVr from "../Divide";
import Sidebar from "../../components/routes/Sidebar";
import MessageList from "../../components/routes/chat/MessageList";
import {StompSessionProvider,} from "react-stomp-hooks";

function Grid() {
    return (
        <main className="d-flex flex-nowrap">
            <div className="d-flex flex-nowrap container-fluid">
                <div style={{width:'2%'}}>
                    <Sidebar/>
                </div>
                    <DivideVr/>
                <StompSessionProvider url={"http://localhost:8080/connect"}>
                    <MessageList/>
                </StompSessionProvider>

            </div>
        </main>
    );
}

export default Grid;