import FiberManualRecordIcon from '@mui/icons-material/FiberManualRecord';
import React, { useEffect, useState } from 'react';
import 'react-alice-carousel/lib/alice-carousel.css';
import MainCaroselData from './MainCaroselData';

const MainCarosel = () => {
    var [index, setIndex] = useState(0);

    useEffect(() => {
        const timer = setInterval(() => {
            setIndex(MainCaroselData.length == index ? 0 : index++);
        }, 1000);
        return () => clearInterval(timer);
    });

    return (
        <div>
            <div className='overflow-hidden flex h-[600px] w-[98%] max-w-[98%] ml-[1%] shadow-2xl'>
                {
                    <img className='cursor-pointer w-[100%] m-1 object-fill  h-auto' src={MainCaroselData[index].image} alt="" />
                }

            </div>
            <div className='flex justify-center mt-4 space-x-3'>
            {
                MainCaroselData.map((item,idx) =>
                    <FiberManualRecordIcon className={idx==index ? '' : 'opacity-30'} sx={{color:"black" , fontSize:"1rem"}} onClick={() => {setIndex(idx)}} />
                )
            }
            </div>
        </div>
    )
}
export default MainCarosel