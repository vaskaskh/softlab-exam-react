import React, {useState} from 'react';
import {Button, Modal} from "react-bootstrap";
import ModalBody from "../ModalBody";

function StudentsModal(props) {
     const [showModal, setShowModal] = useState(false)

const ModalShow = () => {
    setShowModal(true)
}
    return (
        <div>
            <Modal show={showModal} >
                <Modal.Header closeButton>
                    <Modal.Title>Add Student</Modal.Title>
                </Modal.Header>

                <Modal.Body>
                    <ModalBody/>
                </Modal.Body>


            </Modal>
            <Button onClick={ModalShow}>click</Button>
        </div>
    );
}

export default StudentsModal;