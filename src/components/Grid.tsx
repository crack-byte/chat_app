import DivideVr from "./Divide";
import Sidebar from "./Sidebar";
import MessageList from "./MessageList";
import Chat from "./Chat";

function Grid() {
    return (
        <main className="d-flex flex-nowrap">
            <div className="d-flex flex-nowrap container-fluid">
                <div style={{width:'2%'}}>
                    <Sidebar/>
                </div>
                    <DivideVr/>
                    <MessageList/>
                    <DivideVr/>
                    <Chat/>
            </div>
        </main>
    );
}

export default Grid;