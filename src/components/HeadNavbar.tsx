import Container from 'react-bootstrap/Container';
import {Navbar} from "react-bootstrap";

function HeadNavbar() {
  return (
      <Navbar bg="dark" variant="dark">
          <Container>
              <Navbar.Brand href="#home">
                  <img
                      alt=""
                      src="/assets/logo.svg"
                      width="30"
                      height="30"
                      className="d-inline-block align-top"
                  />{' '}
                  Let's Chat
              </Navbar.Brand>
          </Container>
      </Navbar>
  );
}

export default HeadNavbar;