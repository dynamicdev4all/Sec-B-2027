import React, { useEffect } from 'react'
import { useState } from 'react'
import ajay from '../api/springaApi';

const AdminDashboard = () => {

  const [users, setUsers] = useState([
    {
      rollNo: 840923870,
      name: "Shubham Singh",
      branch: "CSE",
      status: true, // if true then account is banned

    },
    {
      rollNo: 98346594375,
      name: "Deepak Singh",
      branch: "CIVIL",
      status: false, // if false then the account is un-banned

    },
  ]);

  // useEffect(() => {

  //   const resp = ajay.get("/admin/show_all");
  //   setUsers(resp);
  // })

  const handleStatus = (id)=>{
    const res = ajay.patch(`admin/manage_users/${id}`);
  }

  return (
    <>
      <h1>Welcome to the Admin Page</h1>
      <h2>Total : {users.length} </h2>

      <table>
        <thead>
          <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Branch</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {users.map((user, index) => {
            return (<tr>
              <td>{user.rollNo}</td>
              <td>{user.name}</td>
              <td>{user.branch}</td>
              <td>{user.status? "Inactive" : "Active"}</td>
              <td>
                
                <button onClick={handleStatus} >{user.status ? "Activate" : "Deactivate"}</button>
                {/* <button>Deactivate</button> */}
              </td>
            </tr>)
          })}
        </tbody>

      </table>
      {/* {users.forEach((index, dto) => {
        if (dto.code === 404) {
          <h3>No Data Found</h3>
        } else if (dto.code === 200) {
          <>
            <h3>{dto.student.rollNo}</h3>
            <h3>{dto.student.name}</h3>
            <h3>{dto.student.branch}</h3>
            <h3>{dto.student.isBanned}</h3>
            <h3>

            </h3>
          </>
  reviewitex.in
        }
      })} */}
    </>
  )
}

export default AdminDashboard
