import React from 'react';
import StudentsTable from "./StudentsTable";
import StudentsModal from "./StudentsModal";

function Students(props) {

    return (
        <div>
            <StudentsModal/>
            <StudentsTable/>
        </div>
    );
}

export default Students;