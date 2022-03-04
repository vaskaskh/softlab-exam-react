import React, {useEffect, useState} from 'react';
import {Button, ButtonToolbar, Form} from "react-bootstrap";
import axios from "axios";

function ModalBody(props) {
    const [students, setStudents] = useState([]);
    const [values, setValues] = useState({
        firstName: '',
        lastName: '',
        personalNo: '',
        email: '',
        birthDate: ''
    });


    async function getStudents() {
        const response = await axios.get('students',
            )
        setStudents(response.data)
    }
    useEffect(() => {
        getStudents().catch(console.error)
    },[])

    useEffect(() => {
        console.log(values)
    })






    const SubmitForm = async (e) => {
        e.preventDefault();
        const {firstName, lastName, birthDate, email, personalNo} = values;
        await axios.post('students', {firstName, lastName, birthDate, email, personalNo})
        SubmitForm && getStudents()
    }

    return (
        <div>
            <Form onSubmit={SubmitForm}>
                <Form.Label >First Name</Form.Label>
                <Form.Control  type="text" value={values.firstName} onChange={e => setValues({ ...values,firstName: e.target.value })}/>
                <Form.Label >Last Name</Form.Label>
                <Form.Control  type="text" value={values.lastName}  onChange={e => setValues({...values, lastName: e.target.value })}/>
                <Form.Label >Personal No</Form.Label>
                <Form.Control  type="number" value={values.personalNo} onChange={e => setValues({...values, personalNo: e.target.value })} />
                <Form.Label >Email</Form.Label>
                <Form.Control  type="email" value={values.email} onChange={e => setValues({...values, email: e.target.value })}/>
                <Form.Label >Birth Date</Form.Label>
                <Form.Control  type="date" value={values.birthDate} onChange={e => setValues({...values, birthDate: e.target.value })}/>

                <ButtonToolbar>
                    <Button  variant="secondary">Close</Button>
                    <Button type="submit" variant="primary">Save changes</Button>
                </ButtonToolbar>
            </Form>
        </div>
    );
}

export default ModalBody;