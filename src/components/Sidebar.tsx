import {Table} from "react-bootstrap";
import {BsChatSquareText} from "react-icons/bs";


function Sidebar() {
    return (
        <Table responsive borderless>
            <tbody>
            <tr>
                <td><BsChatSquareText/></td>
            </tr>
            </tbody>
        </Table>
    );
}

export default Sidebar;