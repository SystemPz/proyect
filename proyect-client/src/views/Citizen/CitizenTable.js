import { Button, Table, Tooltip } from "antd";
import { CloseCircleOutlined, EditOutlined } from "@ant-design/icons";
import { Link } from "react-router-dom";

export default function CitizenTable({ dataSource, deleteCitizen }) {

    const deleteRow = async (id) => {
        await deleteCitizen(id);
    }

    const columns = [
        {
            title: 'Operaciones',
            align: 'center',
            width: '15%',
            render: (row) => {
                return (
                    <>
                        <Tooltip title={`Editar`}>
                            <Link to={`/Citizen/Edit/${row.id}`}>
                                <Button color="#1677ff" shape="circle" icon={<EditOutlined style={{ fontSize: '16px', color: '#1677ff' }} />} />
                            </Link>
                        </Tooltip>
                        {`  |  `}
                        <Tooltip title={`Eliminar`}>

                            <Button onClick={() => deleteRow(row.id)} color="rgb(238,100,100)" shape="circle" icon={<CloseCircleOutlined style={{ fontSize: '16px', color: 'rgb(222,82,82)' }} />} />
                        </Tooltip>
                    </>
                );
            },
        },

        {
            title: 'Nombre',
            sorter: (a, b) => a.name.length - b.name.length,
            dataIndex: 'name',
            key: 'name',
        },
        {
            title: 'Primer apellido',
            sorter: (a, b) => a.firstLastName.length - b.firstLastName.length,
            dataIndex: 'firstLastName',
            key: 'firstLastName',
        },
        {
            title: 'Segundo apellido',
            sorter: (a, b) => a.secondLastName.length - b.secondLastName.length,
            dataIndex: 'secondLastName',
            key: 'secondLastName',
        },

        {
            title: "Sexo",
            align: 'center',
            sorter: (a, b) => a.gender.length - b.gender.length,
            dataIndex: 'gender',
            key: 'gender',
        },
    ];
    return (
        <>
            <Table rowKey="id" dataSource={dataSource} columns={columns} size="small" scroll={{ x: columns.length * 140 }} pagination={{ pageSize: 4, defaultPage: 2 }} />
        </>
    );
}

