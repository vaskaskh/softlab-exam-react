import React from 'react';
import {Container, Nav} from "react-bootstrap";
import {Link, Outlet} from "react-router-dom";

function App() {
  return (
    <div >
        <Container fluid>
        <Nav>
            <Nav.Item>
                <Nav.Link as={Link} to={"/"}>Home</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link as={Link} to={"/students"}>Students</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link as={Link} to={"/teachers"}>Teachers</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link as={Link} to={"/groups"}>Groups</Nav.Link>
            </Nav.Item>
        </Nav>

            <Outlet/>

        </Container>

    </div>
  );
}

export default App;
