import { Button } from '@mui/material';
import React, {useState   } from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import HomeSectionCard from '../HomeSectionCard/HomeSectionCard';
import KeyboardArrowLeftIcon from '@mui/icons-material/KeyboardArrowLeft';
const HomeSectionCarosel = (props) => {
    const [activeIndex,setActiveIndex] = useState(0)
    const responsive = {
        0: { items: 1 },
        568: { items: 3 },
        1024: { items: 5 },
    };
    const items = props.data.map(item => <HomeSectionCard product={item} />)
    const slidePrev = () => setActiveIndex(activeIndex - 1)
    const slideNext = () => setActiveIndex(activeIndex + 1)
    const syncActiveIndex=({item})=>setActiveIndex(item)
    return (
        <div className='px-4 lg:px-8 border'>
            <div className='relative p-5'>
                <AliceCarousel
                    items={items}
                    disableButtonsControls
                    disableDotsControls
                    responsive={responsive}
                    infinite
                    activeIndex={activeIndex}
                    renderSlideInfo={syncActiveIndex}
                />
                <Button variant='contained' className='z-50'
                    sx={{
                        possition: 'absolute', top: '8rem', right: '0rem', transform: 'translateX(2040%) translateY(-850%) rotate(90deg)'
                        , bgcolor: 'white'
                    }} onClick={slideNext}>
                    <KeyboardArrowLeftIcon sx={{ transform: 'rotate(90deg)', color: 'black' }} />
                </Button>
                <Button variant='contained' className='z-50'
                    sx={{
                        possition: 'absolute', top: '8rem', right: '0rem', transform: 'translateX(-230%) translateY(-850%) rotate(90deg)'
                        , bgcolor: 'white'
                    }} onClick={slidePrev}>
                    <KeyboardArrowLeftIcon sx={{ transform: 'rotate(-90deg)', color: 'black' }} />
                </Button>
            </div>
        </div>
    )
}
export default HomeSectionCarosel