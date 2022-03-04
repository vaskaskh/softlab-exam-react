import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Button, ButtonToolbar, Form, Table} from "react-bootstrap";
import Search from "../Search";

function Students(props) {
    const [teachers, setTeachers] = useState([]);
    const [input, setInput] = useState("");

    async function getStudents() {
        const response = await axios.get('teachers')
        setTeachers(response.data)
    }
    useEffect(() => {
        getStudents().catch(console.error)
    },[])



    const filteredTeachers = teachers.filter( teacher => {
        return (teacher.firstName.toLowerCase().includes(input.toLowerCase()) + teacher.lastName.toLowerCase().includes(input.toLowerCase())
            + teacher.email.toLowerCase().includes(input.toLowerCase())
        );

    })





    return (
        <div>
            <Form className="mt-2 mb-3">

            <Search value={teachers.firstName} onchange={e => setInput(e.target.value)} />




                <Table striped bordered hover className="mt-4">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Personal No</th>
                        <th>Email</th>
                        <th>Birth Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {filteredTeachers.map(student => (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td>{student.personalNo}</td>
                            <td>{student.email}</td>
                            <td>{student.birthDate}</td>

                        </tr>
                    ))}

                    </tbody>
                </Table>
            </Form>
        </div>
    );
}

export default Students;